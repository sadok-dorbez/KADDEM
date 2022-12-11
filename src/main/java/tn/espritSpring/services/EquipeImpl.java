package tn.espritSpring.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.espritSpring.DAO.entites.*;
import tn.espritSpring.repositories.IEquipeRepository;
import tn.espritSpring.repositories.IEtudinatRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import java.util.List;

@Slf4j
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

    @Scheduled(cron = "*/10 * * * * *")
    void faireEvoluerEquipes(){

        Iterator<Equipe> le = equipeRepository.findAll().iterator();
        while (le.hasNext()) {
            Equipe equipe = le.next() ;

            if (equipe.getNiveau().equals(Niveau.JUNIOR) || equipe.getNiveau().equals(Niveau.SENIOR)){

                if (findAncienMembre(equipe) >= 3){
                    if (equipe.getNiveau().equals(Niveau.JUNIOR)){
                        equipe.setNiveau(Niveau.SENIOR);

                        System.out.println("passage equipe "+equipe.getIdEquipe()+" de JUINIOR vers SENIOR");
                    }
                    else{ equipe.setNiveau(Niveau.EXPERT);
                    System.out.println("passage equipe "+equipe.getIdEquipe()+" de SENIOR vers EXPERT");}
                    equipeRepository.save(equipe);
                }
            }
        }
    }

    private int findAncienMembre(Equipe equipe) {
        int count = 0 ;
        for (Etudinat etudinat :equipe.getEtudinats()
             ) {
            if(etudinat.getContrat()!=null && etudinat.getContrat().getDateDebutContrat()!=null ){
                System.out.println("dateContrat "+etudinat.getContrat().getDateDebutContrat());
                System.out.println(LocalDate.now());
                LocalDate dateContrat = etudinat.getContrat().getDateDebutContrat();
               // if(ChronoUnit.YEARS.between(dateContrat,LocalDate.now())>=1)

                    count++ ;
            }
        }
        return count ;
    }

    @Override
    public List<Equipe> findEquipeByDetailEquipeThematiqueLike(String th) {
        return equipeRepository.findEquipeByDetailEquipeThematiqueLike(th);
    }

    @Override
    public List<Equipe> findEquipeByEtudinatsIdEtudiant(Integer id) {
        return equipeRepository.findEquipeByEtudinatsIdEtudiant(id);
    }

    @Override
    public List<Equipe> findByEtudinatsIdEtudiantAndDetailEquipeThematiqueNotNull(Integer idEtudiant) {
        return equipeRepository.findByEtudinatsIdEtudiantAndDetailEquipeThematiqueNotNull(idEtudiant);
    }

    @Override
    public List<Equipe> findByEtudinatsIdEtudiantAndEtudinatsDepartementIdDepart(Integer idEtudiant, Integer idDepart) {
        return equipeRepository.findByEtudinatsIdEtudiantAndEtudinatsDepartementIdDepart(idEtudiant, idDepart);
    }
    @Override
    public List<Equipe> retriveEquipeByNiveauAndThematique(Niveau niveau, String thematique) {
        return equipeRepository.retriveEquipeByNiveauAndThematique(niveau, thematique);
    }



}







