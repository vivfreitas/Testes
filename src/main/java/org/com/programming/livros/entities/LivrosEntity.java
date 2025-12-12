package org.com.programming.livros.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_livros")
public class LivrosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLivros;
    private String nameLivros;

    public LivrosEntity(){}

    public LivrosEntity(Long idLivros, String nameLivros) {
        this.idLivros = idLivros;
        this.nameLivros = nameLivros;
    }

    public Long getIdLivros() {
        return idLivros;
    }

    public void setIdLivros(Long idLivros) {
        this.idLivros = idLivros;
    }

    public String getNameLivros() {
        return nameLivros;
    }

    public void setNameLivros(String nameLivros) {
        this.nameLivros = nameLivros;
    }
}
