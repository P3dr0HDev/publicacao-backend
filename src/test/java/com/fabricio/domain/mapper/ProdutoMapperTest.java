package com.fabricio.domain.mapper;

import com.fabricio.domain.ProdutoRepository;
import com.fabricio.domain.dto.ProdutoDTO;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProdutoMapperTest {

    @Test
    public void shouldCreateFromDto() {
        final ProdutoDTO dto = new ProdutoDTO(UUID.randomUUID(), "TESTE", "ELETRONICO");

        final ProdutoRepository produtoREpository = ProdutoMapper.fromDto(ProdutoRepository.Builder.create(), dto);

        assertEquals(dto.nome(), produtoREpository.getNome());
    }

}
