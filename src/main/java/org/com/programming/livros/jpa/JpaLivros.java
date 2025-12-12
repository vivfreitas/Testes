package org.com.programming.livros.jpa;

import org.com.programming.livros.entities.LivrosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaLivros extends JpaRepository<LivrosEntity, Long> {
}
