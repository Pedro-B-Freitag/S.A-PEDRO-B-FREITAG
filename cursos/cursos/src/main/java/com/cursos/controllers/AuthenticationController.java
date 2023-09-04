package com.cursos.controllers;



import com.cursos.Repositorios.PessoaRepositorio;
import com.cursos.domain.curso.Pessoa.AuthenticationDTO;
import com.cursos.domain.curso.Pessoa.Pessoa;
import com.cursos.domain.curso.Pessoa.RegisterDTO;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private PessoaRepositorio repository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Validated AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.PessoaCpf(), data.PessoaSenha());
        //recebe o parametro: cpf e senha juntos como um so
        var auth = this.authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.ok("funcionou");
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Validated RegisterDTO data){
            if(this.repository.findByPessoaCpf(data.pessoa_cpf()) != null) return ResponseEntity.badRequest().build();

            String senhaCriptografada = new BCryptPasswordEncoder().encode(data.pessoa_senha());
            Pessoa novaPessoa = new Pessoa(data.pessoa_cpf(), data.pessoa_nome(), data.pessoa_contato(),data.pessoa_email(),data.pessoa_genero(),
            data.pessoa_data_nascimento(), data.pessoa_cep(), data.pessoa_rua(), data.pessoa_bairro(), data.pessoa_cidade(), data.pessoa_estado(),data.pessoa_nr_residencia(),
            data.pessoa_usuario() , senhaCriptografada, data.pessoa_role());

            this.repository.save(novaPessoa);
            return ResponseEntity.ok().build();
    }
}
