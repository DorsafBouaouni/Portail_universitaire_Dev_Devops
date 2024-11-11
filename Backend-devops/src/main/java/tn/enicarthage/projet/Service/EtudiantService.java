package tn.enicarthage.projet.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.enicarthage.projet.Entity.Etudiant;
import tn.enicarthage.projet.Repository.EtudiantRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService {

    private final EtudiantRepository etudiantRepository;

    @Autowired
    public EtudiantService(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }






    public Optional<Etudiant> getEtudiantByCin(int cin) {
        return etudiantRepository.findByCIN(cin);
    }

    public Optional<Etudiant> updateEtudiantByCin(int cin, Etudiant etudiant) {
        Optional<Etudiant> existingEtudiant = etudiantRepository.findByCIN(cin);
        if (existingEtudiant.isPresent()) {
            etudiant.setId(existingEtudiant.get().getId()); // Assurez-vous que l'ID reste le même
            return Optional.of(etudiantRepository.save(etudiant));
        }
        return Optional.empty();
    }




    // Méthode pour récupérer tous les étudiants
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    // Méthode pour récupérer un étudiant par son ID
    public Etudiant getEtudiantById(Long id) {
        return etudiantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Étudiant non trouvé"));
    }

    // Méthode pour enregistrer un étudiant
    public Etudiant saveEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    // Méthode pour supprimer un étudiant par son ID
    public void deleteEtudiantById(Long id) {
        etudiantRepository.deleteById(id);
    }

    // Méthode pour mettre à jour les attributs d'un étudiant
    public Etudiant updateEtudiant(Long id, Etudiant newEtudiantData) {
        // Vérifie si l'étudiant existe
        Etudiant existingEtudiant = etudiantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Étudiant non trouvé"));

        // Met à jour les attributs de l'étudiant existant avec les nouvelles valeurs
        existingEtudiant.setNom(newEtudiantData.getNom());
        existingEtudiant.setPrenom(newEtudiantData.getPrenom());
        // Mettez à jour d'autres attributs selon vos besoins

        // Enregistre les modifications dans la base de données et renvoie l'étudiant mis à jour
        return etudiantRepository.save(existingEtudiant);
    }
}