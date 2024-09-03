package br.com.fiap.cgenius.auth;

import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthorizationFilter extends OncePerRequestFilter {

    private TokenService tokenService;

    public AuthorizationFilter(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // String token = retrieveToken(request);
        // boolean valid = tokenService.isValid(token);
        // if (valid) {
        //     authenticate(token);
        // }
        // filterChain.doFilter(request, response);
    }

    // private void authenticate(String token) {
    //     Token token = tokenService.getToken(token);
    //     UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(token.getCpf(), null, null);
    //     SecurityContextHolder.getContext().setAuthentication(authentication);
    // }

    // private String retrieveToken(HttpServletRequest request) {
    //     String token = request.getHeader("Authorization");
    //     if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
    //         return null;
    //     }
    //     return token.substring(7, token.length());
    // }

}
