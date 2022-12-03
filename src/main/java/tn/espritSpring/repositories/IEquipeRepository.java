package tn.espritSpring.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.espritSpring.DAO.entites.Equipe;
import tn.espritSpring.DAO.entites.Niveau;

import javax.transaction.Transactional;
import java.util.List;

public interface IEquipeRepository extends CrudRepository<Equipe , Integer> {


    @Query("Select e From Equipe e , DetailEquipe d where e.detailEquipe.idDetailEquipe=d.idDetailEquipe and e.niveau=?1 and d.thematique=?2")
    List<Equipe> retriveEquipeByNiveauAndThematique(Niveau niveau , String thematique);

    @Modifying
    @Transactional
    @Query("DELETE FROM Equipe e WHERE e.niveau=:niveau")
    void deleteEquipeByNiveau( Niveau niveau);

}
