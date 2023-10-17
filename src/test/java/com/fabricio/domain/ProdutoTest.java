package com.fabricio.domain;

import com.fabricio.domain.enums.Categoria;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class ProdutoTest {


    @Test
    public void shouldCreate() {
        final UUID id = UUID.randomUUID();
        final String nome = "TESTE";
        final Categoria categoria = Categoria.ELETRONICO;

        final ProdutoRepository produtoREpository = ProdutoRepository.Builder.create()
                .id(id)
                .nome(nome)
                .categoria(categoria)
                .build();

        assertNotNull(produtoREpository);
        assertEquals(id, produtoREpository.getId());
        assertEquals(nome, produtoREpository.getNome());
        assertEquals(categoria, produtoREpository.getCategoria());
    }

}
