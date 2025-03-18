package dev.architecture.springbootelasticsearch.buisiness.produit;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity
@Table(name = "td_produits")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String description;
    private Double prixUnitaire;
    private Integer quantiteStock;
    private String codeBarre;
    private String categorie;
    private LocalDateTime dateCreation;
    private LocalDateTime dateModification;
    private Boolean statut;
}
