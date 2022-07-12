package padaria.rest.api.padaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import padaria.rest.api.padaria.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
