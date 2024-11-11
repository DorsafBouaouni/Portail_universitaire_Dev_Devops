package tn.enicarthage.projet.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import tn.enicarthage.projet.Entity.Etudiant;
import tn.enicarthage.projet.Repository.EtudiantRepository;
import tn.enicarthage.projet.Service.EtudiantService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class EtudiantServiceTest {

    @Mock
    private EtudiantRepository etudiantRepository;

    @InjectMocks
    private EtudiantService etudiantService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this); // Initialise les mocks avant chaque test
    }

    // Test pour getEtudiantByCin
    @Test
    public void testGetEtudiantByCin_ReturnsEtudiant() {
        int cin = 123456;
        Etudiant etudiant = new Etudiant();
        etudiant.setCin(cin);

        when(etudiantRepository.findByCIN(cin)).thenReturn(Optional.of(etudiant));

        Optional<Etudiant> result = etudiantService.getEtudiantByCin(cin);

        assertTrue(result.isPresent());
        assertEquals(cin, result.get().getCin());
        System.out.println("testGetEtudiantByCin terminé avec succès");
    }

    // Test pour getAllEtudiants
    @Test
    public void testGetAllEtudiants_ReturnsListOfEtudiants() {
        Etudiant etudiant1 = new Etudiant();
        Etudiant etudiant2 = new Etudiant();
        List<Etudiant> etudiants = Arrays.asList(etudiant1, etudiant2);

        when(etudiantRepository.findAll()).thenReturn(etudiants);

        List<Etudiant> result = etudiantService.getAllEtudiants();

        assertEquals(2, result.size());
        assertEquals(etudiant1, result.get(0));
        assertEquals(etudiant2, result.get(1));
        System.out.println("testGetAllEtudiants terminé avec succès");
    }

    // Test pour saveEtudiant
    @Test
    public void testSaveEtudiant_Success() {
        Etudiant etudiant = new Etudiant();
        etudiant.setNom("Dupont");

        when(etudiantRepository.save(etudiant)).thenReturn(etudiant);

        Etudiant result = etudiantService.saveEtudiant(etudiant);

        assertNotNull(result);
        assertEquals("Dupont", result.getNom());
        System.out.println("testSaveEtudiant terminé avec succès");
    }

    @Test
    public void testGetEtudiantByCin() {
        // Arrange
        int cin = 123456;
        Etudiant etudiant = new Etudiant();
        etudiant.setCin(cin);
        Mockito.when(etudiantRepository.findByCIN(cin)).thenReturn(Optional.of(etudiant));

        // Act
        Optional<Etudiant> result = etudiantService.getEtudiantByCin(cin);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(cin, result.get().getCin());
        Mockito.verify(etudiantRepository, Mockito.times(1)).findByCIN(cin);
        System.out.println("testGetEtudiantByCin terminé avec succès");

    }
}