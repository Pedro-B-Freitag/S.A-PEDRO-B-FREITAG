package com.cursos.modulos.curso.Pessoa.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.cursos.modulos.curso.Pessoa.entidades.Pessoa;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    public String gerarToken(Pessoa pessoa) {
        return JWT.create()
                .withIssuer("Curso")
                .withSubject(pessoa.getUsername())
                .withClaim("id", pessoa.getId())
                .withExpiresAt(LocalDateTime.now()
                        .plusMinutes(10)
                        .toInstant(ZoneOffset.of("-03:00"))
                ).sign(Algorithm.HMAC256("secreta"));
    }
}
