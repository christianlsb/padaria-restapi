package padaria.rest.api.padaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import padaria.rest.api.padaria.model.Produto;
import padaria.rest.api.padaria.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }
    @Override
    public Optional <Produto> findById(long id) {
        return produtoRepository.findById(id);
    }
    @Override
    public Produto save(Produto produto) {
        try {
            return produtoRepository.save(produto);
        }catch (Exception e){
            throw new IllegalArgumentException("Fudeo", e);
        }
    }
    @Override
    public Produto update(Produto updatedProduto, long id) {
        return produtoRepository.findById(id)
                .map(u -> {
                    u.setNome(updatedProduto.getNome());
                    u.setQuantidade(updatedProduto.getQuantidade());
                    return produtoRepository.save(u);
                })
                .orElseGet(() ->{
                    updatedProduto.setId(id);
                    return  produtoRepository.save(updatedProduto);
                });
    }
    @Override
    public Produto create(Produto produto) {
        return produtoRepository.save(produto);
    }
    @Override
    public void delete(long id) {
        produtoRepository.deleteById(id);
    }

}

