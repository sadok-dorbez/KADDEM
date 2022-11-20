package tn.esprit.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.projet.entities.Contrat;
import tn.esprit.projet.entities.Departement;
import tn.esprit.projet.entities.Option;

import java.util.List;

public interface DepartementRepository extends JpaRepository<Departement,Long> {



    @Query("SELECT  departement FROM Departement  departement  , Etudiant e where departement.idDepart=e.departement.idDepart and e.option = :op")
    List<Departement> retrieveDepartementByOptionEtudiant(@Param("op") Option op);
}
