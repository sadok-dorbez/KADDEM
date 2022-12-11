package tn.espritSpring.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.espritSpring.DAO.entites.DetailEquipe;

import java.util.List;

public interface IDetailEquipeRepository extends CrudRepository<DetailEquipe , Integer> {
    List<DetailEquipe> findByThematiqueLike (String thematique);
}
