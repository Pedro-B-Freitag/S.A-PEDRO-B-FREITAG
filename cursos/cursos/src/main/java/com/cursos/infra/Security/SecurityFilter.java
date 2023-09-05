package com.cursos.infra.Security;

import com.cursos.Repositorios.PessoaRepositorio;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    TokenService tokenService;

    @Autowired
    PessoaRepositorio pessoaRepositorio;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.recoverToken(request);
        if(token != null){
            var cpf = tokenService.validateToken(token);
            UserDetails user = pessoaRepositorio.findByPessoaCpf(cpf);
            //pegando todas as informacoes q o springsecurity precisa para fazer as validacoes dos proximos endpoints, se tem ROLE admin ou se esta autenticado
            var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities() );
            //salvamos no contexto da autenticacao o usuario
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        //chamando proximo filtro que sera o usernamePasswordAuthenticationFilter
        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request){
        var authHeader = request.getHeader("Authorization");
        if(authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }
}
