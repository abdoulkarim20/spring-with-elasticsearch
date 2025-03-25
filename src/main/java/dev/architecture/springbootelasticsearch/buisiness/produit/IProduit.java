package dev.architecture.springbootelasticsearch.buisiness.produit;

import dev.architecture.springbootelasticsearch.buisiness.produit.dtos.ProduitGetDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IProduit {
    void saveProduit(Produit produit);

    void saveAllProduits(List<Produit> produits);

    List<ProduitGetDTO> getAll();

    /**
     * Recherche les documents avec le nom et la description avec des mots cle
     */
    List<ProduitGetDTO> searchProduitByDescriptionAndName(String keyword);

    /**
     * Recherche les documents avec le nom et la description avec des mots cle en faisant un boost
     */
    List<ProduitGetDTO> searchWithBoost(String keyword);

    /**
     * Recherche les documents avec un classement
     */
    /*List<ProduitGetDTO> filterProducts(String keyword, double minPrice, double maxPrice);*/
    Page<ProduitGetDTO> paginatedSearch(String keyword, int page, int size);
}
