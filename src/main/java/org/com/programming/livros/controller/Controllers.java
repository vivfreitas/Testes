package org.com.programming.livros.controller;

import org.com.programming.livros.entities.LivrosEntity;
import org.com.programming.livros.service.ServiceLivros;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("teste")
public class Controllers {

    private final ServiceLivros serviceLivros;

    public Controllers(ServiceLivros serviceLivros) {
        this.serviceLivros = serviceLivros;
    }

    @GetMapping("listas")
    public ResponseEntity<List<LivrosEntity>> lists(){
        return ResponseEntity.ok(serviceLivros.livrosEntities());
    }

    @PostMapping("criacao")
    public ResponseEntity<LivrosEntity> entity(@RequestBody LivrosEntity livrosEntity){
        return ResponseEntity.ok(serviceLivros.salvarLivro(livrosEntity));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Object> atualizarLivro(@RequestBody LivrosEntity obj, @PathVariable Long id){
        Object c = serviceLivros.updateBook(obj, id);
        return ResponseEntity.ok(c);
    }
}
