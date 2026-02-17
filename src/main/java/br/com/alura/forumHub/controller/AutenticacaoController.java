package br.com.alura.forumHub.controller;

import br.com.alura.forumHub.infra.security.DtoTokenJwt;
import br.com.alura.forumHub.infra.security.TokenService;
import br.com.alura.forumHub.infra.security.UsuarioDetails;
import br.com.alura.forumHub.model.autenticacao.DtoAutenticacao;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DtoAutenticacao dados) {
        var token = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var authentication = manager.authenticate(token);


        var usuarioDetails = (UsuarioDetails) authentication.getPrincipal();
        var tokenJwt = tokenService.gerarToken(usuarioDetails.getUsuario());


        return ResponseEntity.ok(new DtoTokenJwt(tokenJwt));
    }
}