package com.br.productsapi.controller;

import com.br.productsapi.model.Produto;
import com.br.productsapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("produtos")
    public List<Produto> listaProdutos(){
       return produtoRepository.findAll();

    }

    @GetMapping("produtos/{id}")
    public Produto listaProdutoUnico(@PathVariable(value = "id") long id){
        return produtoRepository.findById(id);

    }

    @PostMapping("produtos")
    public Produto salvaProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }



}
