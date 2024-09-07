package br.com.fiap.cgenius.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain config(HttpSecurity http, AuthorizationFilter authorizationFilter) throws Exception {
        http.csrf(csrf -> csrf.disable());

        http.authorizeHttpRequests(auth ->
                auth
                        .requestMatchers(HttpMethod.POST, "/login").permitAll()

                        .requestMatchers(HttpMethod.GET, "/atendente").authenticated()
                        .requestMatchers(HttpMethod.POST, "/atendente").authenticated()
                        .requestMatchers(HttpMethod.GET, "/atendente/{id}").authenticated()
                        .requestMatchers(HttpMethod.GET, "/atendente/cpf/{cpf_atendente}").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/atendente/{id}").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/atendente/cpf/{cpf_atendente}").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/atendente/{id}").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/atendente/cpf/{cpf_atendente}").authenticated()
                    
                        .requestMatchers(HttpMethod.GET, "/cliente").authenticated()
                        .requestMatchers(HttpMethod.POST, "/cliente").authenticated()
                        .requestMatchers(HttpMethod.GET, "/cliente/{id}").authenticated()
                        .requestMatchers(HttpMethod.GET, "/cliente/cpf/{cpf_cliente}").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/cliente/{id}").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/cliente/cpf/{cpf_cliente}").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/cliente/{id}").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/cliente/cpf/{cpf_cliente}").authenticated()
                        
                        .requestMatchers(HttpMethod.GET, "/especificacao").authenticated()
                        .requestMatchers(HttpMethod.POST, "/especificacao").authenticated()
                        .requestMatchers(HttpMethod.GET, "/especificacao/{id}").authenticated()
                        .requestMatchers(HttpMethod.GET, "/especificacao/cpf/{cpf_cliente}").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/especificacao/{id}").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/especificacao/cpf/{cpf_cliente}").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/especificacao/{id}").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/especificacao/cpf/{cpf_cliente}").authenticated()
                        
                        .requestMatchers(HttpMethod.GET, "/venda").authenticated()
                        .requestMatchers(HttpMethod.POST, "/venda").authenticated()
                        .requestMatchers(HttpMethod.GET, "/venda/{id}").authenticated()
                        .requestMatchers(HttpMethod.GET, "/atendente/cpfatendente/{cpf_atendente}").authenticated()
                        .requestMatchers(HttpMethod.GET, "/venda/cpfcliente/{cpf_cliente}").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/venda/{id}").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/venda/{id}").authenticated()

                        .requestMatchers(HttpMethod.GET, "/venda").authenticated()
                        .requestMatchers(HttpMethod.POST, "/venda").authenticated()
                        .requestMatchers(HttpMethod.GET, "/venda/{id}").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/venda/{id}").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/venda/{id}").authenticated()

                        .requestMatchers(HttpMethod.GET, "/plano").authenticated()
                        .requestMatchers(HttpMethod.POST, "/plano").authenticated()
                        .requestMatchers(HttpMethod.GET, "/plano/{id}").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/plano/{id}").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/plano/{id}").authenticated() 
        );

        http.addFilterBefore(authorizationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
