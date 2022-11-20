package tn.esprit.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.projet.entities.Contrat;
import tn.esprit.projet.entities.Equipe;
import tn.esprit.projet.entities.Niveau;

import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe,Long> {

    List<Equipe> findEquipesByEtudiantsIdEtudiant(Long idEtudiant);
    List<Equipe>findEquipeByDetailEquipe1ThematiqueLike(String th);

    List<Equipe> findEquipesByEtudiantsIdEtudiantAndDetailEquipe1ThematiqueNotNull(Long id);
    List<Equipe> findEquipesByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(Long id1,Long id2);

    @Modifying
    @Transactional
    @Query(" DELETE  FROM Equipe e WHERE e.niveau = :niveau")
    void deleteEquipeByNiveau( @Param("niveau") Niveau niveau);



    @Query("SELECT  equipe from Equipe equipe , DetailEquipe deq where equipe.idEquipe = deq.equipe.idEquipe and deq.thematique= :thematique and equipe.niveau= :niveau")
    List<Equipe> retriveEquipeByNiveauAndThematique(@Param("niveau") Niveau niveau ,@Param("thematique") String thematique);

}
