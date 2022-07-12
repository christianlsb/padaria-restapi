package padaria.rest.api.padaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import padaria.rest.api.padaria.model.Produto;
import padaria.rest.api.padaria.service.ProdutoService;

import java.util.List;
import java.util.Optional;

@RestController

public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping("/produtos")
    public List<Produto> findAll(){
        return produtoService.findAll();
    }
    @GetMapping("/produtos/{id}")
    public Optional<Produto> findById(@PathVariable long id){
        return produtoService.findById(id);
    }

    @PostMapping("/produtos")
    public String criarNovoProduto(@RequestBody Produto produto){
        try {
            produtoService.save(produto);
            return "Produto criado";
        }catch (Exception e){
            throw new IllegalArgumentException("Erro", e);
        }
    }
    @PutMapping("/produtos/{id}")
    public Produto update(@RequestBody Produto produto, @PathVariable long id){
        return  produtoService.update(produto, id);
    }
    @DeleteMapping("/produtos/{id}")
    public void delete(@PathVariable long id){
        produtoService.delete(id);
    }
}


