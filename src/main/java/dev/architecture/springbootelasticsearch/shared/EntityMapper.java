package dev.architecture.springbootelasticsearch.shared;

import java.util.List;

public interface EntityMapper<D, E> {
    D toDto(E entity);

    E toEntity(D dto);

    List<E> toEntities(List<D> dtos);

    List<D> toDto(List<E> entityList);
}

