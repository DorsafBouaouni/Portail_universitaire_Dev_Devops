package tn.enicarthage.projet.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.enicarthage.projet.Entity.Etudiant;
import tn.enicarthage.projet.Service.EtudiantService;


import java.util.Optional;

@RestController


@RequestMapping("/api/etudiant")
@CrossOrigin (origins = "*")
public class EtudiantController {

    private final EtudiantService etudiantService;

    @Autowired
    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }



    @GetMapping("/{cin}")
    public ResponseEntity<Etudiant> getEtudiantByCin(@PathVariable int cin) {
        Optional<Etudiant> etudiant = etudiantService.getEtudiantByCin(cin);
        return etudiant.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{cin}")
    public ResponseEntity<Void> updateEtudiantByCin(@PathVariable int cin, @RequestBody Etudiant etudiant) {
        Optional<Etudiant> updatedEtudiant = etudiantService.updateEtudiantByCin(cin, etudiant);
        return updatedEtudiant.isPresent() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }
}









