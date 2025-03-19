package dev.architecture.springbootelasticsearch.buisiness.produit.mappers;

import dev.architecture.springbootelasticsearch.buisiness.produit.Produit;
import dev.architecture.springbootelasticsearch.buisiness.produit.dtos.ProduitGetDTO;
import dev.architecture.springbootelasticsearch.shared.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProduitGetMapper extends EntityMapper<ProduitGetDTO, Produit> {
}
