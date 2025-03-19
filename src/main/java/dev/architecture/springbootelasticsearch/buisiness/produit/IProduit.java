package dev.architecture.springbootelasticsearch.buisiness.produit;

import dev.architecture.springbootelasticsearch.buisiness.produit.dtos.ProduitGetDTO;

import java.util.List;

public interface IProduit {
    void saveProduit(Produit produit);
    void saveAllProduits(List<Produit> produits);

    List<ProduitGetDTO> getAll();
}
