package tn.enicarthage.projet.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.enicarthage.projet.Entity.Etudiant;

import java.util.Optional;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    Optional<Etudiant> findByCIN(int cin);
}
