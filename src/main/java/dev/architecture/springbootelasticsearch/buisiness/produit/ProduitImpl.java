package dev.architecture.springbootelasticsearch.buisiness.produit;

import dev.architecture.springbootelasticsearch.buisiness.produit.dtos.ProduitGetDTO;
import dev.architecture.springbootelasticsearch.buisiness.produit.mappers.ProduitGetMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
@Transactional
@Slf4j
public class ProduitImpl implements IProduit {
    private final ProduitRepository produitRepository;
    private final ProduitGetMapper produitGetMapper;

    public ProduitImpl(ProduitRepository produitRepository, ProduitGetMapper produitGetMapper) {
        this.produitRepository = produitRepository;
        this.produitGetMapper = produitGetMapper;
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
        return produitGetMapper.toDto(StreamSupport.stream(produits.spliterator(),false).toList());
    }
}
