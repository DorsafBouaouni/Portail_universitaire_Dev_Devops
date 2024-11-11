package tn.enicarthage.projet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.enicarthage.projet.Entity.Cour;

@Repository
public interface CourRepository extends JpaRepository<Cour, String> {

}





