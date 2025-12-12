package org.com.programming.livros.service;

import org.com.programming.livros.entities.LivrosEntity;
import org.com.programming.livros.jpa.JpaLivros;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceLivros {

    private final JpaLivros jpaLivros;

    public ServiceLivros(JpaLivros jpaLivros) {
        this.jpaLivros = jpaLivros;
    }

    public LivrosEntity salvarLivro(LivrosEntity entity){
        return jpaLivros.save(entity);
    }

    public List<LivrosEntity> livrosEntities(){
        return jpaLivros.findAll();
    }

    public LivrosEntity updateBook(LivrosEntity objNew, Long idLivro){
        LivrosEntity obj = jpaLivros.findById(idLivro)
                .orElseThrow(()-> new NullPointerException("Id não encontrado."));
        updateLivro(obj, objNew);
        return jpaLivros.save(objNew);
    }

    private void updateLivro(LivrosEntity obj, LivrosEntity objNew) {
        obj.setNameLivros(obj.getNameLivros());
    }
}
