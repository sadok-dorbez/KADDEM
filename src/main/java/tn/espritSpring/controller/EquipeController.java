package tn.espritSpring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.espritSpring.DAO.entites.Equipe;
import tn.espritSpring.DAO.entites.Etudinat;
import tn.espritSpring.DAO.entites.Niveau;
import tn.espritSpring.repositories.IEquipeRepository;
import tn.espritSpring.services.IEquipeService;

import java.util.List;

@RestController
@RequestMapping("/Equipe")
@RequiredArgsConstructor
public class EquipeController {

    private final  IEquipeService iEquipeService;

    private final IEquipeRepository equipeRepository ;

    @GetMapping("/getAllEquipe")
    public List<Equipe> getAllEquipe() {
        return iEquipeService.getAllEquipe();
    }

    @PostMapping("/addEquipe")
    public Equipe addEquipe(@RequestBody Equipe e) {return iEquipeService.addEquipe(e);}


    @PutMapping("/updateEquipe")
    public Equipe updateEquipe(@RequestBody Equipe e) {
        return iEquipeService.updateEquipe(e);
    }


    @DeleteMapping("/deleteEquipe/{idEquipe}")
    public void deleteEquipe(@PathVariable("idEquipe") int idEquipe) {iEquipeService.deleteEquipe(idEquipe);}

    @GetMapping("/getbyid/{idEquipe}")
    public Equipe getEquipeById (@PathVariable("idEquipe") int idEquipe) {
        return iEquipeService.getEquipeById(idEquipe);
    }

    @GetMapping("/getEquipeByNiveauAndThematique/{niveau}/{thematique}")
    public List<Equipe> retriveEquipeByNiveauAndThematique(@PathVariable("niveau") Niveau niveau ,@PathVariable("thematique") String thematique){
        return equipeRepository.retriveEquipeByNiveauAndThematique(niveau,thematique);
    }

    @DeleteMapping("/DeleteEquipeByNiveau/{niveau}")
    public void deleteEquipeByNiveau(@PathVariable("niveau") Niveau niveau){
        equipeRepository.deleteEquipeByNiveau(niveau);
    }

}
