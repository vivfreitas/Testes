package org.com.programming.livros.service;

import org.com.programming.livros.entities.LivrosEntity;
import org.com.programming.livros.jpa.JpaLivros;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class) /* Habilita o Mockito para o Junit. */
public class ServiceLivrosTest {

    @Mock
    private JpaLivros jpaLivros; // Criando uma simulação do BD.

    @InjectMocks
    private ServiceLivros serviceLivros;

    @Test
    void deveCriarUmLivroComSucesso(){
        LivrosEntity paraSalvarLivro = new LivrosEntity(null, "Entendendo Algoritmos");
        LivrosEntity livroSalvo = new LivrosEntity(1L, "Entendendo Algoritmo");

        // When funciona como um contrato retornando o livro salvo.
        /* "Quando o 'paraSalvarLivro' for chamado, retorne o 'livroSalvo'. */
        when(jpaLivros.save(paraSalvarLivro)).thenReturn(livroSalvo);

        // Executando o serviço de salvamento para testar.
        LivrosEntity resposta = serviceLivros.salvarLivro(paraSalvarLivro);

        assertNotNull(resposta);
        assertEquals(1L, resposta.getIdLivros());
        assertEquals("Entendendo Algoritmo", resposta.getNameLivros());

        verify(jpaLivros,times(1)).save(paraSalvarLivro);
    }

    @Test
    void deveListarTodos(){
        // 1. Dados de Saída Simulados
        LivrosEntity livro1 = new LivrosEntity(1L, "Livro Um");
        LivrosEntity livro2 = new LivrosEntity(2L, "Livro Dois");
        List<LivrosEntity> listaDoBanco = Arrays.asList(livro1, livro2);

        when(jpaLivros.findAll()).thenReturn(listaDoBanco);
        List<LivrosEntity> resposta = serviceLivros.livrosEntities();

        assertNotNull(resposta);
        assertEquals(2, resposta.size()); /* Verifica se a lista tem o tamanho correto. */
        assertEquals("Livro Um", resposta.get(0).getNameLivros());

        verify(jpaLivros, times(1)).findAll();

    }

    @Test
    void deveAtualizarLivros(){

    }
}
