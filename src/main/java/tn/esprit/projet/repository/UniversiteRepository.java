package tn.esprit.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.projet.entities.Etudiant;
import tn.esprit.projet.entities.Universite;

public interface UniversiteRepository extends JpaRepository<Universite,Long> {
}
