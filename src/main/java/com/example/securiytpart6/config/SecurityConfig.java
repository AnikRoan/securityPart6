package com.example.securiytpart6.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.httpBasic()
                .and()
                .authorizeRequests()
                .requestMatchers(HttpMethod.GET,"/demo/**").hasAuthority("read")//group "/demo/**" have access
                //in this group just Get method have access
               // .requestMatchers("/demo2").hasAuthority("read")//build filter who have access

                .anyRequest().authenticated()
                .and().csrf().disable()//don't do this in real world
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        var usd = new InMemoryUserDetailsManager();

        var u1 = User.withUsername("bill")
                .password(passwordEncoder().encode("12345"))
                .authorities("read")//GrantedAuthority contract same .roles
                .build();

        var u2 = User.withUsername("john")
                .password(passwordEncoder().encode("12345"))
                .authorities("write")
                .build();

        usd.createUser(u1);
        usd.createUser(u2);

        return usd;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();

    }
}
