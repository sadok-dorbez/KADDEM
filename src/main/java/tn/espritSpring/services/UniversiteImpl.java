package tn.espritSpring.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.espritSpring.DAO.entites.Contart;
import tn.espritSpring.DAO.entites.Departement;
import tn.espritSpring.DAO.entites.Etudinat;
import tn.espritSpring.DAO.entites.Universite;
import tn.espritSpring.repositories.IUniversiteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
 public class UniversiteImpl implements IUniversiteService{


    @Autowired
    private final  IUniversiteRepository universiteRepository;



    @Override
    public List<Universite> getAllUniversite() {
        return (List<Universite>) universiteRepository.findAll();
    }
    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }
    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }
    @Override
    public void deleteUniversite(Integer idUniv) {universiteRepository.deleteById(idUniv);}
    @Override
    public Universite getUniversiteById(Integer idUniv) {
        return universiteRepository.findById(idUniv).orElse(null);
    }
}
