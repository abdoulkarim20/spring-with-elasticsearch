package dev.architecture.springbootelasticsearch.shared;


import lombok.Data;

@Data
public class SearchHit<T> {
    private T content;  // L'entité ou DTO représentant le contenu du document
    private String id;  // L'ID du document
    private float score;
}
