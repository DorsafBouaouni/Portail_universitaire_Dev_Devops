package tn.enicarthage.projet.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.enicarthage.projet.Entity.DemandeCertificatPresence;
import tn.enicarthage.projet.Entity.Etudiant;
import tn.enicarthage.projet.Repository.DemandeCertificatPresenceRepository;
import tn.enicarthage.projet.Service.DemandeCertificatPresenceService;
import tn.enicarthage.projet.Service.EmailService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class DemandeCertificatPresenceServiceTest {

    @Mock
    private DemandeCertificatPresenceRepository demandeCertificatPresenceRepository;

    @Mock
    private EmailService emailService;

    @InjectMocks
    private DemandeCertificatPresenceService demandeCertificatPresenceService;

    private DemandeCertificatPresence demandeCertificatPresence;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        demandeCertificatPresence = new DemandeCertificatPresence();
        // Remplir les détails de demandeCertificatPresence selon votre structure
        // demandeCertificatPresence.setRaison("Demande de certificat");
        // ...
    }

    @Test

    public void testCreerDemandeCertificatPresence() {
        // Créez un étudiant fictif
        Etudiant etudiant = new Etudiant();
        etudiant.setNom("Dupont");
        etudiant.setPrenom("Jean");

        // Créez une demande fictive
        DemandeCertificatPresence demande = new DemandeCertificatPresence();
        demande.setRaison("Demande pour des raisons personnelles");
        demande.setAnneeAcademique("2023-2024");
        demande.setEtudiant(etudiant); // Assurez-vous que l'étudiant est initialisé

        // Mockez la réponse du repository
        when(demandeCertificatPresenceRepository.save(any(DemandeCertificatPresence.class))).thenReturn(demande);

        // Appeler la méthode
        DemandeCertificatPresence savedDemande = demandeCertificatPresenceService.creerDemandeCertificatPresence(demande);

        // Vérifiez les résultats
        assertNotNull(savedDemande);
        assertEquals("Dupont", savedDemande.getEtudiant().getNom());
        verify(emailService).sendEmail(anyString(), anyString(), anyString());
        System.out.println("testCreerDemandeCertificatPresence terminé avec succès");
    }
}
