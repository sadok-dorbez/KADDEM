package tn.esprit.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.projet.entities.Contrat;
import tn.esprit.projet.entities.DetailEquipe;

import java.util.List;

public interface DetailEquipeRepository extends JpaRepository<DetailEquipe,Long> {

    List<DetailEquipe> findByThematiqueLike (String thematique);
}
