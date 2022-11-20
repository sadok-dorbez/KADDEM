package tn.esprit.projet.services;

import org.springframework.data.repository.query.Param;
import tn.esprit.projet.entities.Equipe;
import tn.esprit.projet.entities.Niveau;

import java.util.List;

public interface IEquipeService {
    List<Equipe> getAlleqp();
    Equipe addeqp(Equipe E);
    Equipe updateeqp(Equipe E);
    void deleteeqp(long id);
    Equipe geteqbyid(long id);


    List<Equipe> findEquipesByEtudiantsIdEtudiant(Long idEtudiant);
    List<Equipe>findEquipeByDetailEquipe1ThematiqueLike(String th);
    List<Equipe> findEquipesByEtudiantsIdEtudiantAndDetailEquipe1ThematiqueNotNull(Long id);
    List<Equipe> findEquipesByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(Long id1,Long id2);
    void deleteEquipeByNiveau( Niveau niveau);

    List<Equipe> retriveEquipeByNiveauAndThematique(Niveau niveau ,String thematique);



}
