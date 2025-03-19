package dev.architecture.springbootelasticsearch.buisiness.produit;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDateTime;

@Document(indexName = "products")
@Data
public class Produit {
    @Id
    private String id;
    @Field(type = FieldType.Text)
    private String nom;
    @Field(type = FieldType.Text)
    private String description;
    @Field(type = FieldType.Double)
    private Double prixUnitaire;
    @Field(type = FieldType.Long)
    private Long quantiteStock;
    @Field(type = FieldType.Text)
    private String codeBarre;
    @Field(type = FieldType.Text)
    private String categorie;
    @Field(type = FieldType.Date, name = "dateCreation", format = {}, pattern = "uuuu-MM-dd'T'HH:mm:ss")
    private LocalDateTime dateCreation;
    @Field(type = FieldType.Date, name = "dateModification", format = {}, pattern = "uuuu-MM-dd'T'HH:mm:ss")
    private LocalDateTime dateModification;
    @Field(type = FieldType.Boolean)
    private Boolean statut;
}
