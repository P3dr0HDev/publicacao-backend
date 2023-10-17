package com.fabricio.domain.repositories;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@RequestScoped
public class ProdutoRepository {

    @Inject
    private EntityManager em;

    public List<com.fabricio.domain.ProdutoRepository> findAll() {
        return em.createQuery("select p from Produto p").getResultList();
    }

    public void save(final com.fabricio.domain.ProdutoRepository produtoREpository) {
        em.persist(produtoREpository);
    }

}
