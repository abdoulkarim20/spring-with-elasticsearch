package dev.architecture.springbootelasticsearch.buisiness.produit;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends ElasticsearchRepository<Produit, Long> {
}
