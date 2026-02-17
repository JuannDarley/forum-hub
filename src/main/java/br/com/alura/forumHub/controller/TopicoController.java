package br.com.alura.forumHub.controller;


import br.com.alura.forumHub.model.topico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity novoTopico(@RequestBody DtoTopico dados){

        var topico = new Topico(dados);
        repository.save(topico);

        return ResponseEntity.ok(topico);
    }

    @GetMapping
    public ResponseEntity<Page<DtoListagemTopico>> listarTopicos(@PageableDefault(size = 10, sort = {"dataCriacao"}, direction = Sort.Direction.DESC) Pageable paginacao) {

        var page = repository.findAll(paginacao);
        var pageDto = page.map(DtoListagemTopico::new);
        return ResponseEntity.ok(pageDto);

    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoDetalhamentoTopico> detalhar(@PathVariable Long id) {

        var topico = repository.getReferenceById(id);

        return ResponseEntity.ok(new DtoDetalhamentoTopico(topico));
    }

    @PutMapping("/{id}")
    @Transactional

    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody DtoAtualizacaoTopico dados) {

        var topico = repository.getReferenceById(id);
        topico.atualizacaoTopico(dados);

        return ResponseEntity.ok(new DtoDetalhamentoTopico(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {

        if (!repository.existsById(id)) {

            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();

    }

}
