package com.fabricio.domain;

import com.fabricio.domain.enums.Categoria;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "PRODUTOS")
public class ProdutoRepository {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    private UUID id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "CATEGORIA")
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public ProdutoRepository() {
    }

    public ProdutoRepository(final UUID id, final String nome, final Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }


    public static final class Builder {
        private ProdutoRepository produtoRepository;

        private Builder(final ProdutoRepository produtoRepository) {
            this.produtoRepository = produtoRepository;
        }

        public static Builder create() {
            return new Builder(new ProdutoRepository());
        }

        public static Builder from(final ProdutoRepository produtoRepository) {
            return new Builder(produtoRepository);
        }

        public Builder id(UUID id) {
            this.produtoRepository.id = id;
            return this;
        }

        public Builder nome(String nome) {
            this.produtoRepository.nome = nome;
            return this;
        }

        public Builder categoria(Categoria categoria) {
            this.produtoRepository.categoria = categoria;
            return this;
        }

        public ProdutoRepository build() {
            return produtoRepository;
        }
    }
}
