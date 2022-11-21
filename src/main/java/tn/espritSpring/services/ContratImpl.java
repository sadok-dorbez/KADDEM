package tn.espritSpring.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.espritSpring.DAO.entites.Contart;

import tn.espritSpring.repositories.IContartRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor

 public class ContratImpl implements IContratService{


    @Autowired
    public final  IContartRepository contartRepository ;

    @Override
    public List<Contart> getAllContrat() {
        return (List<Contart>) contartRepository.findAll();
    }
    @Override
    public Contart addContrat(Contart c) {
        return contartRepository.save(c);
    }
    @Override
    public Contart updateContrat(Contart c) {
        return contartRepository.save(c);
    }
    @Override
    public void deleteContrat(Integer idContart) {
        contartRepository.deleteById(idContart);
    }

    @Override
    public Contart getContratById(Integer idContart) {
        return contartRepository.findById(idContart).orElse( null);
    }

    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {
        return contartRepository.nbContratsValides(startDate,endDate);
    }






}
