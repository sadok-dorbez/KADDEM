package tn.espritSpring.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.espritSpring.DAO.entites.Equipe;
import tn.espritSpring.DAO.entites.Niveau;

import java.util.List;

public interface IEquipeRepository extends CrudRepository<Equipe , Integer> {



}
