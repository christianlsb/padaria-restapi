package padaria.rest.api.padaria.service;

import padaria.rest.api.padaria.model.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {
    public List findAll();
    public Optional<Produto> findById(long id);
    public Produto save(Produto produto);
    public Produto create(Produto produto);
    public Produto update(Produto produto, long id);
    public void delete (long id);

}
