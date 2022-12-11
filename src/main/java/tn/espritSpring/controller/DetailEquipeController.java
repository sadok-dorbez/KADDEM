package tn.espritSpring.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.espritSpring.DAO.entites.DetailEquipe;
import tn.espritSpring.DAO.entites.Etudinat;
import tn.espritSpring.services.IDetailEquipeService;

import java.util.List;

@RestController
@RequestMapping("/DetailEquipe")
@RequiredArgsConstructor
public class DetailEquipeController {

    @Autowired
    public final  IDetailEquipeService iDetailEquipeService;

    @GetMapping("/getAllDetailEquipe")
    public List<DetailEquipe> getAllDetailEquipe() {
        return iDetailEquipeService.getAllDetailEquipe();
    }


    @PostMapping("/addDetailEquipe")
    public DetailEquipe addDetailEquipe(@RequestBody DetailEquipe d) {return iDetailEquipeService.addDetailEquipe(d);}

    //Affectation equipe au detail equipe
    @PutMapping("/updateDetailEquipe/{idDetailEquipe}/{idEquipe}")
    public void updateDetailEquipe(@PathVariable ("idDetailEquipe") Integer idDetailEquipe, @PathVariable ("idEquipe") Integer idEquipe )
    { iDetailEquipeService.assignDetailEquipeToEquipe(idDetailEquipe,idEquipe);}

    @DeleteMapping("/deleteDetailEquipe/{idDetailEquipe}")
    public void deleteDetailEquipe(@PathVariable("idDetailEquipe") int idDetailEquipe) {iDetailEquipeService.deleteDetailEquipe(idDetailEquipe);}

    @GetMapping("/getbyidDetailEquipe/{idDetailEquipe}")
    public DetailEquipe getDetailEquipeById(@PathVariable("idDetailEquipe") int idDetailEquipe) {
        return iDetailEquipeService.getDetailEquipeById(idDetailEquipe);
    }

    @GetMapping("/getDetailByThematique/{thematique}")
    public List<DetailEquipe> getDetailByThematique(@PathVariable("thematique")String thematique){
        return iDetailEquipeService.findByThematiqueLike(thematique);
    }

    @PutMapping("/put/{idDetailEquipe}")
    public void update(@PathVariable("idDetailEquipe") Integer id, @RequestBody DetailEquipe detailEquipe){
        detailEquipe.setIdDetailEquipe(id);
        iDetailEquipeService.update(detailEquipe);
    }

}
