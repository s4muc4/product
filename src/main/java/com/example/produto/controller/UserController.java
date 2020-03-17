package com.example.produto.controller;

import java.util.HashMap;

import com.example.produto.model.Produto;
import com.example.produto.service.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * UserController
 */
@Controller
@RequestMapping("/produto")
public class UserController {

    @Autowired
    private ProdutoService ps;

    @GetMapping("/{codigo}")
    public ModelAndView getProduto(@PathVariable("codigo") int codigo){

        ModelAndView mv = new ModelAndView("userview_byID");

        Produto produto = ps.getProdutoByID(codigo);

        mv.addObject("produto", produto);

        return mv;
    }

    @GetMapping("/produtosEmEstoque")
    public ModelAndView getProdutos() {
        
        ModelAndView mv = new ModelAndView("userview_emEstoque");

        HashMap<Integer, Produto> produto = ps.getProdutosEmEstoque(); 

        mv.addObject("produtos", produto.values());

        return mv;
    }

    @GetMapping("/produtosValorAcima/{valor}")
    public ModelAndView getProdutos(@PathVariable("valor") double valor) {
        
        ModelAndView mv = new ModelAndView("userview_ValorAcima");

        HashMap<Integer, Produto> produto = ps.getProdutosByValorAcima(valor); 

        mv.addObject("produtos", produto.values());

        return mv;
    }

    @GetMapping("/produtosValorAbaixo/{valor}")
    public ModelAndView getProdutosvalorAbaixo(@PathVariable("valor") double valor) {
        
        ModelAndView mv = new ModelAndView("userview_ValorAbaixo");

        HashMap<Integer, Produto> produto = ps.getProdutosByValorAbaixo(valor);

        mv.addObject("produtos", produto.values());

        return mv;
    }

    
    
}
