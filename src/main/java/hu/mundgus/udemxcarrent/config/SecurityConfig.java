package hu.mundgus.udemxcarrent.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/index.html", "/css/**", "/js/**", "/images/**", "/api/**").permitAll() // Engedélyezzük a statikus fájlokat
                .anyRequest().authenticated()
            )
            .formLogin()
            .defaultSuccessUrl("/", true) // ✅ Ha mégis bejelentkezne, az index.html-re irányítjuk
            .and()
            .logout()
            .logoutSuccessUrl("/") // ✅ Kijelentkezés után vissza az index.html-re
            .permitAll();

        return http.build();
    }
}
