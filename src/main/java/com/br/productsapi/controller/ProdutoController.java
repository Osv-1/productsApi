package com.br.productsapi.controller;

import com.br.productsapi.model.Produto;
import com.br.productsapi.repository.ProdutoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
@Api(value = "API REST PRODUCTS")
@CrossOrigin(origins = "*")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("produtos")
    @ApiOperation(value = "RETURN LIST PRODUCT")
    public List<Produto> listaProdutos() {
        return produtoRepository.findAll();

    }

    @GetMapping("produtos/{id}")
    @ApiOperation(value = "SEARCH FOR PRODUCT ID")
    public Produto listaProdutoUnico(@PathVariable(value = "id") long id) {
        return produtoRepository.findById(id);

    }

    @PostMapping("produtos")
    @ApiOperation(value = "SAVE PRODUCT")
    public Produto salvaProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    @DeleteMapping("produtos")
    @ApiOperation(value = "DELETE PRODUCT ")
    public void deletaProduto(@RequestBody Produto produto) {
        produtoRepository.delete(produto);
    }

    @PutMapping("produtos")
    @ApiOperation(value = "UPDATE PRODUCT ")
    public Produto atualizaProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }


}
