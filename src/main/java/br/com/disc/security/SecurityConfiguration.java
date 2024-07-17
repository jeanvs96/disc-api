package br.com.disc.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static br.com.disc.model.enums.RoleNameEnum.*;
import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final TokenService tokenService;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(
            auth -> auth
                .requestMatchers(GET,"/user/first-name").hasAnyAuthority(ADMIN.name(), USER.name())
                .requestMatchers(PUT,"/user/confirm-email").hasAnyAuthority(ADMIN.name(), USER.name(), VERIFIED_USER.name())
                .requestMatchers(PUT,"/user/logged/password/**").hasAnyAuthority(ADMIN.name(), USER.name(), VERIFIED_USER.name())
                .requestMatchers(POST,"/questions/save").hasAnyAuthority(ADMIN.name(), VERIFIED_USER.name())
                .requestMatchers(PUT,"/questions/update").hasAnyAuthority(ADMIN.name(), VERIFIED_USER.name())
                .requestMatchers(POST,"/results/**").hasAnyAuthority(ADMIN.name(), VERIFIED_USER.name())
                .requestMatchers(GET,"/results/**").hasAnyAuthority(ADMIN.name(), USER.name())
                .requestMatchers(GET,"/test/**").hasAnyAuthority(ADMIN.name(), VERIFIED_USER.name())
                .requestMatchers(GET,"/test/check-ongoing-test").hasAnyAuthority(VERIFIED_USER.name(), USER.name())
                .requestMatchers(DELETE,"/test/delete-ongoing-test").hasAnyAuthority(VERIFIED_USER.name(), USER.name())
                .requestMatchers(POST,"/email/account-confirmation").hasAnyAuthority(ADMIN.name(), USER.name())
                .anyRequest()
                .authenticated()
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(new TokenAuthenticationFilter(tokenService), UsernamePasswordAuthenticationFilter.class)
            );

        return http.build();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                .allowedMethods("*")
                .exposedHeaders("Authorization", "Access-Control-Allow-Origin");
            }
        };
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers(
                "/api/v1/auth/**",
                "/v2/api-docs",
                "/v3/api-docs",
                "/v3/api-docs/**",
                "/swagger-resources",
                "/swagger-resources/**",
                "/configuration/ui",
                "/configuration/security",
                "/swagger-ui/**",
                "/webjars/**",
                "/swagger-ui.html",
                "/",
                "/sign-in",
                "/sign-in/code",
                "/user/sign-up",
                "/states",
                "/hello",
                "/cities/**",
                "/education-levels",
                "/fields-of-interest",
                "/email/authentication-code",
                "/user/code/update-password"
        );
    }
}
