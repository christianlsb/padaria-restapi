package padaria.rest.api.padaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import padaria.rest.api.padaria.model.Produto;
import padaria.rest.api.padaria.service.ProdutoService;

import java.util.List;

@RestController

public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping("/produtos")
    public List<Produto> findAll(){
        return produtoService.findAll;
    }
}
