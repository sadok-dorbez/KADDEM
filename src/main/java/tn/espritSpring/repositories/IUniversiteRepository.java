package tn.espritSpring.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.espritSpring.DAO.entites.Universite;

import java.util.List;

public interface IUniversiteRepository extends CrudRepository<Universite , Integer> {

}
