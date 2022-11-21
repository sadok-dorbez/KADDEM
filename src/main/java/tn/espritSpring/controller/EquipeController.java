package tn.espritSpring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.espritSpring.DAO.entites.Equipe;
import tn.espritSpring.DAO.entites.Etudinat;
import tn.espritSpring.DAO.entites.Niveau;
import tn.espritSpring.services.IEquipeService;

import java.util.List;

@RestController
@RequestMapping("/Equipe")
@RequiredArgsConstructor
public class EquipeController {

    public final  IEquipeService iEquipeService;

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
}
