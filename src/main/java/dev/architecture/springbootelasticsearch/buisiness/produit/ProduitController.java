package dev.architecture.springbootelasticsearch.buisiness.produit;

import dev.architecture.springbootelasticsearch.buisiness.produit.dtos.ProduitGetDTO;
import dev.architecture.springbootelasticsearch.shared.VoidResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produits")
public class ProduitController {
    private final IProduit iProduit;

    public ProduitController(IProduit iProduit) {
        this.iProduit = iProduit;
    }
    @PostMapping("/save")
    public ResponseEntity<VoidResponse> save(@RequestBody Produit produit) {
        iProduit.saveProduit(produit);
        return ResponseEntity.status(HttpStatus.OK).body(new VoidResponse(HttpStatus.OK.value(), "Enregistrement réussi"));
    }
    @PostMapping("/save-all")
    public ResponseEntity<VoidResponse> save(@RequestBody List<Produit> produits) {
        iProduit.saveAllProduits(produits);
        return ResponseEntity.status(HttpStatus.OK).body(new VoidResponse(HttpStatus.OK.value(), "Enregistrement réussi"));
    }
    @GetMapping("/liste")
    public List<ProduitGetDTO> listeProduit() {
        return iProduit.getAll();
    }
}
