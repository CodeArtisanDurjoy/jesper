package naztech.app.jesper.config;

/*
 * ==============================================================
 * @Project: jesper
 * File: SecurityConfig
 * Created: 1/31/25
 * Author: DURJOY ACHARJYA
 * Email: da-durjoy@outlook.com
 * ==============================================================
 *
 * Copyright (c) 2025, system error.inc.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * system error.inc. You shall not disclose such confidential information
 * and shall use it only in accordance with the terms of the license
 * agreement you entered into with naztech.inc.
 *
 * ==============================================================
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import java.util.Arrays;
import java.util.List;


//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//  //  @Bean
//  ///  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        http
////                .csrf(csrf -> csrf.disable())  // Disable CSRF for API endpoints
////                .authorizeHttpRequests(auth -> auth
////                        .requestMatchers("/api/**").permitAll()
////                        .anyRequest().authenticated()
////                )
////                .headers(headers -> headers
////                        .frameOptions(frame -> frame.disable())
////                );
////
////        return http.build();
////    }
////
// //for more security CSRF
//        @Bean
//        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//            http
//                    .csrf(csrf -> csrf
//                            .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                            .ignoringRequestMatchers("/api/**")  // Disable CSRF only for API endpoints
//                    )
//                    .authorizeHttpRequests(auth -> auth
//                            .requestMatchers(
//                                    "/api/books/**",
//                                    "/api/users/**",
//                                    "/api/reading-progress/**",
//                                    "/api/audits/**",
//                                    "/api/admins/**"
//                            ).permitAll()
//                            .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
//                            .anyRequest().authenticated()
//                    )
//                    .cors(cors -> cors.configurationSource(corsConfigurationSource()));
//
//            return http.build();
//        }
//
//        @Bean
//        public CorsConfigurationSource corsConfigurationSource() {
//            CorsConfiguration configuration = new CorsConfiguration();
//            configuration.setAllowedOrigins(Arrays.asList("*"));
//            configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
//            configuration.setAllowedHeaders(Arrays.asList("*"));
//            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//            source.registerCorsConfiguration("/**", configuration);
//            return source;
//        }
//}
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Disable CSRF
                .csrf(csrf -> csrf.disable())

                // Configure CORS
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))

                // Configure authorization
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/**").permitAll()
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
                        .requestMatchers("/uploads/*").permitAll()
                        .requestMatchers("/h2-console/**").permitAll()  // If you're using H2 console

                        .anyRequest().authenticated()
                )

                // Allow frames for H2 console
                .headers(headers -> headers.frameOptions().disable());

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("*"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setExposedHeaders(List.of("Authorization"));
        configuration.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}