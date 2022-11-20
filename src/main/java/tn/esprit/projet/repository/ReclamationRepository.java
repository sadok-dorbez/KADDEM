package tn.esprit.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.projet.entities.Reclamation;

import java.util.Optional;

public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {

}
