package dev.architecture.springbootelasticsearch.buisiness.produit;

import dev.architecture.springbootelasticsearch.buisiness.produit.dtos.ProduitGetDTO;
import dev.architecture.springbootelasticsearch.buisiness.produit.mappers.ProduitGetMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.*;
import org.springframework.data.elasticsearch.core.*;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
@Slf4j
public class ProduitImpl implements IProduit {
    private final ProduitRepository produitRepository;
    private final ProduitGetMapper produitGetMapper;
    private final ElasticsearchOperations elasticsearchOperations;

    public ProduitImpl(ProduitRepository produitRepository, ProduitGetMapper produitGetMapper, ElasticsearchOperations elasticsearchOperations) {
        this.produitRepository = produitRepository;
        this.produitGetMapper = produitGetMapper;
        this.elasticsearchOperations = elasticsearchOperations;
    }

    @Override
    public void saveProduit(Produit produit) {
        produitRepository.save(produit);
    }

    @Override
    public void saveAllProduits(List<Produit> produits) {
        produitRepository.saveAll(produits);
    }

    @Override
    public List<ProduitGetDTO> getAll() {
        Iterable<Produit> produits = produitRepository.findAll();
        return produitGetMapper.toDto(StreamSupport.stream(produits.spliterator(), false).toList());
    }

    @Override
    public List<ProduitGetDTO> searchProduitByDescriptionAndName(String keyword) {
        Query query = NativeQuery.builder()
                .withQuery(q -> q.multiMatch(m -> m.fields("nom","description").query(keyword))).build();
        return elasticsearchOperations.search(query, Produit.class)
                .stream()
                .map(SearchHit::getContent)
                .map(produitGetMapper::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public List<ProduitGetDTO>searchWithBoost(String keyword){
        Query query = NativeQuery.builder()
                .withQuery(q -> q.multiMatch(m -> m
                        .fields("name^3.0", "description^1.0")  // Application de boosts sur les champs
                        .query(keyword)
                ))
                .build();
        return elasticsearchOperations.search(query, Produit.class)
                .stream()
                .map(SearchHit::getContent)
                .map(produitGetMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Page<ProduitGetDTO> paginatedSearch(String keyword, int page, int size) {
        Query query = NativeQuery.builder()
                .withQuery(q -> q.multiMatch(m -> m.fields("nom","description").query(keyword)))
                .withPageable(PageRequest.of(page, size))
                .build();
        SearchHits<Produit>searchHits = elasticsearchOperations.search(query, Produit.class);
        SearchPage<Produit>searchPage= SearchHitSupport.searchPageFor(searchHits, query.getPageable());
        return searchPage.map(SearchHit::getContent).map(produitGetMapper::toDto);
    }

    /*@Override
    public List<ProduitGetDTO> filterProducts(String keyword, double minPrice, double maxPrice) {
        Query query = NativeQuery.builder()
                .withQuery(q -> q.bool(b -> b
                        .must(m -> m.match(t -> t
                                .field("description")  // Correct : Champ spécifié correctement
                                .query(keyword)        // Correct : Valeur de la recherche
                        ))
                        .filter(f -> f.range(r -> r
                                .field("prixUnitaire")     // ✅ Champ "price" (correct)
                                .from(minPrice)     // ✅ Prix minimum (nouvelle syntaxe possible)
                                .to(maxPrice)       // ✅ Prix maximum (nouvelle syntaxe possible)
                                .includeLower(true) // Inclut la borne inférieure
                                .includeUpper(true) // Inclut la borne supérieure
                        ))
                ))
                .build();

        return elasticsearchOperations.search(query, Produit.class)
                .stream()
                .map(SearchHit::getContent)
                .collect(Collectors.toList());
    }*/
}
