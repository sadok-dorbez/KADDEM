package tn.espritSpring.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import tn.espritSpring.DAO.entites.Universite;

public interface UniversiteRepository extends JpaRepository<Universite,Long> {
Universite findUniversiteByNomUni(String nomUniv);
}
