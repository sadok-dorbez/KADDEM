package tn.espritSpring.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.espritSpring.DAO.entites.*;
import tn.espritSpring.repositories.IEquipeRepository;
import tn.espritSpring.repositories.IEtudinatRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipeImpl implements IEquipeService{


    @Autowired
    private final   IEquipeRepository equipeRepository ;

    private final IEtudinatRepository etudinatRepository ;






    @Override
    public List<Equipe> getAllEquipe() {
        return (List<Equipe>) equipeRepository.findAll();
    }

    @Override
    public Equipe addEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public void deleteEquipe(Integer idEquipe) {equipeRepository.deleteById(idEquipe);}

    @Override
    public Equipe getEquipeById(Integer idEquipe) {
        return equipeRepository.findById(idEquipe).orElse(null);
    }



}
