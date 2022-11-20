package tn.esprit.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.projet.entities.Contrat;


public interface ContratRepository extends JpaRepository<Contrat,Long> {
}
