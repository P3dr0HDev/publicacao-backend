package com.fabricio.resource;

import com.fabricio.domain.ProdutoRepository;
import com.fabricio.domain.dto.ProdutoDTO;
import com.fabricio.domain.mapper.ProdutoMapper;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("api/produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    @Inject
    private com.fabricio.domain.repositories.ProdutoRepository repository;

    @GET
    public Response findAll() {
        final List<ProdutoRepository> produtoRepositories = repository.findAll();
        final List<ProdutoDTO> dtos = produtoRepositories.stream()
                .map(ProdutoMapper::toDto)
                .toList();

        return Response.ok(dtos).build();
    }

    @POST
    @Transactional
    public Response create(final ProdutoDTO dto) {
        final ProdutoRepository produtoRepository = ProdutoMapper.fromDto(ProdutoRepository.Builder.create(), dto);
        repository.save(produtoRepository);

        return Response.status(201).build();
    }

}
