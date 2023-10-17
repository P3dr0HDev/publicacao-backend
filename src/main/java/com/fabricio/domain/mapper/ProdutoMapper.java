package com.fabricio.domain.mapper;

import com.fabricio.domain.ProdutoRepository;
import com.fabricio.domain.dto.ProdutoDTO;
import com.fabricio.domain.enums.Categoria;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class ProdutoMapper {

    public static ProdutoRepository fromDto(final ProdutoRepository.Builder builder, final ProdutoDTO dto) {
        return builder
                .nome(dto.nome())
                .categoria(Categoria.valueOf(dto.categoria()))
                .build();
    }

    public static ProdutoDTO toDto(final ProdutoRepository produtoRepository) {
        return new ProdutoDTO(produtoRepository.getId(), produtoRepository.getNome(), produtoRepository.getCategoria().name());
    }

}
