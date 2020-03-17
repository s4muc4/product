package com.example.produto.repository;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.produto.model.Produto;

import org.springframework.stereotype.Repository;

/**
 * produtoRepository
 */

 @Repository
public class ProdutoRepository {

    public HashMap<Integer, Produto> repository = new HashMap<Integer, Produto>();
    
    public ProdutoRepository()
    {
        repository.put(1, new Produto(1, "Cola", 7.0, 0));
        repository.put(2, new Produto(2, "Tesoura", 6.0, 56));
        repository.put(3, new Produto(3, "Lápis", 1.50, 167));
        repository.put(4, new Produto(4, "Caderno", 15.00, 35));
        repository.put(5, new Produto(5, "Caneta", 2.00, 155));
        repository.put(6, new Produto(6, "Giz", 18.00, 14));
        repository.put(7, new Produto(7, "Borracha", 4.00, 124));
        repository.put(8, new Produto(8, "Apontador", 7.0, 74));
        repository.put(9, new Produto(9, "Grafite", 5.00, 56));
        repository.put(10, new Produto(10, "Agenda", 13.00, 1));
    }

    public Produto getProdutoByID(int id){
        return repository.get(id);
    }

    public HashMap<Integer, Produto> getProdutos(){
      
        return repository;
    }

   
    
}