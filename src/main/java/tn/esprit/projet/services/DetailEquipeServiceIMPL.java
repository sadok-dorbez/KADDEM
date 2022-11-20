package tn.esprit.projet.services;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projet.entities.DetailEquipe;
import tn.esprit.projet.repository.DetailEquipeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class DetailEquipeServiceIMPL  implements  IDetailEquipeService{

    DetailEquipeRepository detailEquipeRepository;

    @Override
    public List<DetailEquipe> getAlldeqp() {
        return detailEquipeRepository.findAll();
    }

    @Override
    public DetailEquipe adddeqp(DetailEquipe E) {
        return detailEquipeRepository.save(E);
    }

    @Override
    public DetailEquipe updatedeqp(DetailEquipe E) {
        return detailEquipeRepository.save(E);
    }

    @Override
    public void deletedeqp(long id) {
        detailEquipeRepository.deleteById(id);

    }

    @Override
    public DetailEquipe getdeqpbyid(long id) {
        return detailEquipeRepository.findById(id).orElse(null);
    }

    @Override
    public List<DetailEquipe> findByThematiqueLike(String thematique) {
        return detailEquipeRepository.findByThematiqueLike(thematique);
    }
}
