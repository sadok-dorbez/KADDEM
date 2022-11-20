package tn.esprit.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.projet.entities.Equipe;
import tn.esprit.projet.entities.Etudiant;
import tn.esprit.projet.entities.Option;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {

     Etudiant findEtudiantByprenom(String prenom) ;

     Etudiant findEtudiantBynom(String nom) ;
     @Modifying
     @Transactional
     @Query(" update Etudiant set option = :op where idEtudiant = :idEtudiant")
     void updateEtudiantByOption(@Param("op") Option op , @Param("idEtudiant") Long idEtudiant);


     @Query("SELECT etudiant FROM Etudiant etudiant"
             + " INNER JOIN etudiant.equipes equipe"
             + " INNER JOIN DetailEquipe detail"
             + " ON detail.IdEquipe = equipe.idEquipe"
             + " where detail.thematique= :thematique")
     List<Etudiant> retrieveEtudiantByEquipeThematique ( @Param("thematique") String thematique);





}
