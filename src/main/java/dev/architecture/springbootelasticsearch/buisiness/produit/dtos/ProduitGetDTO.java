package dev.architecture.springbootelasticsearch.buisiness.produit.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProduitGetDTO {
    private String id;
    private String nom;
    private String description;
    private Double prixUnitaire;
    private Long quantiteStock;
    private String codeBarre;
    private String categorie;
    private LocalDateTime dateCreation;
    private LocalDateTime dateModification;
    private Boolean statut;
}
