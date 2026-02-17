package br.com.alura.forumHub.controller;


import br.com.alura.forumHub.model.DtoTopico;
import br.com.alura.forumHub.model.Topico;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @PostMapping
    @Transactional
    public ResponseEntity novoTopico(@RequestBody DtoTopico dados){

        var topico = new Topico(dados);

        return ResponseEntity.ok(topico);
    }
}
