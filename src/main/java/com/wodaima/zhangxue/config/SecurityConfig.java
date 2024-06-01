package com.wodaima.zhangxue.config;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // 安全过滤器链配置
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 禁用 CSRF 保护
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        // 对 "/api/hello" 请求需要 "USER" 角色权限
                        .requestMatchers("api/hello").hasRole("USER")
                        // 对 "/login" 和 "/error" 请求允许所有权限
                        .requestMatchers("/login", "/error").permitAll()
                        // 其他请求需要身份验证
                        .anyRequest().authenticated()
                )
                .formLogin(formLogin -> formLogin
                        // 登录页面配置为 "/login"
                        .loginPage("/login")
                        // 登录成功后默认跳转到 "/api/hello"
                        .defaultSuccessUrl("/api/hello", true)
                        .permitAll()
                )
                // 配置登出，允许所有权限
                .logout(LogoutConfigurer::permitAll);
        return http.build();
    }

    // 用户详细信息服务配置
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        // 创建测试用户，用户名为 "test"，密码为 "123456"，角色为 "USER"
        manager.createUser(User.withUsername("test")
                .password(passwordEncoder().encode("123456"))
                .roles("USER")
                .build());
        return manager;
    }

    // 密码编码器配置
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
