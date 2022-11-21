package tn.espritSpring.services;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.espritSpring.DAO.entites.*;
import tn.espritSpring.repositories.IContartRepository;
import tn.espritSpring.repositories.IEquipeRepository;
import tn.espritSpring.repositories.IEtudinatRepository;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EtudiantImp implements IEtudiantService{


    private final  IEtudinatRepository etudinatRepository ;
    private final IEquipeRepository equipeRepository ;
    private final IContartRepository contartRepository ;


    @Override
    public void assignContratToEtudiant(Integer idEtudiant , Integer idContart) {
        Contart contart=contartRepository.findById(idContart).orElse(null);
        Etudinat etudinat=getEtudiantById(idEtudiant);
        contart.setEtudinat(etudinat);
        contartRepository.save(contart);
    }

    @Override
    @Transactional
    public Etudinat addAndAssignEtudiantToEquipeAndContract(Etudinat e, Integer idContart, Integer idEquipe) {
        //1. Sauvgarder l'objet etudiant et le récupérer en mémoire via l'affectation
        e = etudinatRepository.save(e);
       // etudinatRepository.save(e);
        Contart contrat = contartRepository.findById(idContart).orElse(null);
        Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);
        contrat.setEtudinat(e);
        contartRepository.save(contrat);
        //Il faut ajouter une condution sur la collection equipes
        if (e.getEquipes()==null){
            Set<Equipe> equipes = new HashSet<>();
            equipes.add(equipe);
            e.setEquipes(equipes);
        }
        else {
            e.getEquipes().add(equipe);
        }

        return e ;
    }



    @Override
    public void assignEtudiantToEquipe(Integer idEtudiant, Integer idEquipe){

        Equipe equipe=equipeRepository.findById(idEquipe).orElse(null);
        Etudinat etudinat=etudinatRepository.findById(idEtudiant).orElse(null);
        etudinat.getEquipes().add(equipe);
        etudinatRepository.save(etudinat);

    }



    @Override
    public Etudinat retrieveEtudiant(Integer idEtudiant) {
        Etudinat e = etudinatRepository.findById(idEtudiant).orElse(null);
        return  e;
    }


    @Override
    public List<Etudinat> getAllEtudiant() {
        return (List<Etudinat>) etudinatRepository.findAll();
    }

    @Override
    public Etudinat addEtudiant(Etudinat etudinat) {
        return etudinatRepository.save(etudinat);
    }

    @Override
    public Etudinat updateEtudiant(Etudinat etudinat) {
        return etudinatRepository.save(etudinat);
    }

    @Override
    public void deleteEtudiant(Integer idEtudiant) { etudinatRepository.deleteById(idEtudiant);}

    @Override
    public Etudinat getEtudiantById(Integer idEtudiant) {
        return etudinatRepository.findById(idEtudiant).orElse( null);
    }

    @Override
    public List<Etudinat> retriveEtudiantByDepartementName(String nomDepart) {
        return etudinatRepository.retriveEtudiantByDepartementName(nomDepart);
    }
}
