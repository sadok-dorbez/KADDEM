package tn.esprit.projet.services;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import tn.esprit.projet.entities.Equipe;
import tn.esprit.projet.entities.Niveau;
import tn.esprit.projet.repository.EquipeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EquipeServiceIIMPL implements  IEquipeService{



    EquipeRepository equipeRepository;

    @Override
    public List<Equipe> getAlleqp() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe addeqp(Equipe E) {
        return equipeRepository.save(E);
    }

    @Override
    public Equipe updateeqp(Equipe E) {
        return equipeRepository.save(E);
    }

    @Override
    public void deleteeqp(long id) {
        equipeRepository.deleteById(id);
    }

    @Override
    public Equipe geteqbyid(long id) {
        return equipeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Equipe> findEquipesByEtudiantsIdEtudiant(Long idEtudiant) {
        return equipeRepository.findEquipesByEtudiantsIdEtudiant(idEtudiant);
    }

    @Override
    public List<Equipe>findEquipeByDetailEquipe1ThematiqueLike(String th) {
        return equipeRepository.findEquipeByDetailEquipe1ThematiqueLike(th);
    }

    @Override
    public List<Equipe> findEquipesByEtudiantsIdEtudiantAndDetailEquipe1ThematiqueNotNull(Long id) {
        return equipeRepository.findEquipesByEtudiantsIdEtudiantAndDetailEquipe1ThematiqueNotNull(id);
    }

    @Override
    public List<Equipe> findEquipesByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(Long id1, Long id2) {
        return equipeRepository.findEquipesByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(id1, id2);
    }

    @Override
    public void deleteEquipeByNiveau(Niveau niveau) {
         equipeRepository.deleteEquipeByNiveau(niveau);
    }

    @Override
    public List<Equipe> retriveEquipeByNiveauAndThematique(Niveau niveau, String thematique) {
        return equipeRepository.retriveEquipeByNiveauAndThematique(niveau,thematique);
    }




  /*  @Override
    public List<Equipe>findEquipeByEtudiantsAndDetailEquipe1ThematiqueNonNull(Long idEtudiant) {
        return  equipeRepository.findEquipeByEtudiantsAndDetailEquipe1ThematiqueNonNull(idEtudiant);
    }
*/
}
