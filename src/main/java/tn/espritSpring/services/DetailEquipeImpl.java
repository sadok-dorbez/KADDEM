package tn.espritSpring.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.espritSpring.DAO.entites.DetailEquipe;
import tn.espritSpring.DAO.entites.Equipe;
import tn.espritSpring.repositories.IDetailEquipeRepository;
import tn.espritSpring.repositories.IEquipeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetailEquipeImpl implements IDetailEquipeService{

    @Autowired
    private final   IDetailEquipeRepository detailEquipeRepository ;

    private final IEquipeRepository equipeRepository ;



    @Override
    public void assignDetailEquipeToEquipe(Integer idDetailEquipe , Integer idEquipe) {

        Equipe equipe=equipeRepository.findById(idEquipe).orElse(null);
        DetailEquipe detailEquipe=getDetailEquipeById(idDetailEquipe);
        equipe.setDetailEquipe(detailEquipe);
        equipeRepository.save(equipe);
    }


    @Override
    public List<DetailEquipe> getAllDetailEquipe() {
        return (List<DetailEquipe>) detailEquipeRepository.findAll();
    }

    @Override
    public DetailEquipe addDetailEquipe(DetailEquipe d) {
        return detailEquipeRepository.save(d);
    }

    @Override
    public DetailEquipe updateDetailEquipe(DetailEquipe d) {
        return detailEquipeRepository.save(d);
    }

    @Override
    public void deleteDetailEquipe(Integer idDetailEquipe) {
        detailEquipeRepository.deleteById(idDetailEquipe);
    }

    @Override
    public DetailEquipe getDetailEquipeById(Integer idDetailEquipe) {
        return detailEquipeRepository.findById(idDetailEquipe).orElse(null);
    }

    @Override
    public List<DetailEquipe> findByThematiqueLike(String thematique) {
        return detailEquipeRepository.findByThematiqueLike(thematique);
    }
}