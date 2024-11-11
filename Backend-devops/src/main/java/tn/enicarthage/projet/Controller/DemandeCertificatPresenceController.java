package tn.enicarthage.projet.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.enicarthage.projet.Entity.DemandeCertificatPresence;
import tn.enicarthage.projet.Service.DemandeCertificatPresenceService;

@RestController
@RequestMapping("/api/DemandeCetificatPresence")
@CrossOrigin (origins = "*")
public class DemandeCertificatPresenceController {

    private final DemandeCertificatPresenceService demandeCertificatPresenceService;

    @Autowired
    public DemandeCertificatPresenceController(DemandeCertificatPresenceService demandeCertificatPresenceService) {
        this.demandeCertificatPresenceService = demandeCertificatPresenceService;
    }

    @PostMapping()
    public ResponseEntity<DemandeCertificatPresence> createDemandeCertificatPresence(@RequestBody DemandeCertificatPresence demandeCertificatPresence) {
        DemandeCertificatPresence nouvelleDemande = demandeCertificatPresenceService.createDemande(demandeCertificatPresence);
        return ResponseEntity.ok(nouvelleDemande);
    }
}

