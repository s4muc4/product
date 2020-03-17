package com.example.produto.service;

import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.produto.model.Produto;
import com.example.produto.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ProdutoService
 */
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository pd;

    public Produto getProdutoByID(int id)
    {
        Produto produto = pd.getProdutoByID(id);

        return produto;
    }
    public HashMap<Integer, Produto> getProdutosEmEstoque(){
        HashMap<Integer, Produto> produtos = pd.getProdutos();
        HashMap<Integer, Produto> produtoEmEstoque = new HashMap<>();
        int i=0;

        for(i=0;i<produtos.size();i++)
        {
            if(produtos.get(i+1).getEstoque()>0)
            {
                System.out.println(produtos.get(i+1).getEstoque());
                produtoEmEstoque.put(produtos.get(i+1).getCodigo(), produtos.get(i+1));
                
            }
            
        }
        System.out.println("\n"+ produtoEmEstoque.size());
        for(i=0;i<produtoEmEstoque.size();i++)
        {
            System.out.println("\n" + produtoEmEstoque.get(i+2));
        }
         return produtoEmEstoque;
    }
    public HashMap<Integer, Produto> getProdutosByValorAcima(double valor){
        HashMap<Integer, Produto> produtos = pd.getProdutos();
        HashMap<Integer, Produto> produtosValorAcima = new HashMap<>();
        int i=0;

        System.out.println("aaaaa" +produtos.size());

        for(i=0;i<produtos.size();i++)
        {
            if(produtos.get(i+1).getValor()>valor)
            {
                System.out.println(produtos.get(i+1).getValor());
                produtosValorAcima.put(produtos.get(i+1).getCodigo(), produtos.get(i+1));
                
            }
            
        }
        System.out.println("\n"+ produtosValorAcima.size());
        for(i=0;i<produtosValorAcima.size();i++)
        {
            System.out.println("\n" + produtosValorAcima.get(i));
        }
        
         return produtosValorAcima;
    }

    public HashMap<Integer, Produto> getProdutosByValorAbaixo(double valor){
        HashMap<Integer, Produto> produtos = pd.getProdutos();
        HashMap<Integer, Produto> produtosValorAbaixo = new HashMap<>();
        int i=0;

        System.out.println("aaaaa" +produtos.size());

        for(i=0;i<produtos.size();i++)
        {
            if(produtos.get(i+1).getValor()<valor)
            {
                System.out.println("AAAAA");
                System.out.println(produtos.get(i+1).getValor());
                produtosValorAbaixo.put(produtos.get(i+1).getCodigo(), produtos.get(i+1));
                
            }
            
        }
        System.out.println("\n"+ produtosValorAbaixo.size());
        for(i=0;i<produtosValorAbaixo.size();i++)
        {
            System.out.println("\n" + produtosValorAbaixo.get(i));
        }
        
         return produtosValorAbaixo;
    }
}