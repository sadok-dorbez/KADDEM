package tn.esprit.projet.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projet.entities.DetailEquipe;
import tn.esprit.projet.entities.Equipe;
import tn.esprit.projet.entities.Niveau;
import tn.esprit.projet.services.IEquipeService;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class EquipeController {


    IEquipeService iEquipeService;

    @GetMapping("/Eqp")
    public List<Equipe> Geteqp(){

        return  iEquipeService.getAlleqp();
    }
    @PostMapping("/addEquipe")
    public void  addEqp(@RequestBody Equipe D){
       iEquipeService.addeqp(D);
    }


    @PutMapping("/putEquipe/{IdEquipe}")
    public void updateEqp(@PathVariable("IdEquipe") Long id, @RequestBody Equipe C){

        C.setIdEquipe(id);
       iEquipeService.updateeqp(C);
    }

    @GetMapping("/findIdEtudiant/{idEtudiant}")
    public List<Equipe> findEtudiantbyPrenom(@PathVariable("idEtudiant") Long id){

        return  iEquipeService.findEquipesByEtudiantsIdEtudiant(id);
    }
    @GetMapping("/findTH/{thematique}")
    public List<Equipe> findbyTH(@PathVariable("thematique") String thematique){

        return  iEquipeService.findEquipeByDetailEquipe1ThematiqueLike(thematique);
    }
    @GetMapping("/findzouz/{idEtudiant}/{idDepart}")
    public List<Equipe> findbyzouz(@PathVariable("idEtudiant") Long id1,@PathVariable("idDepart") Long id2){

        return  iEquipeService.findEquipesByEtudiantsIdEtudiantAndEtudiantsDepartementIdDepart(id1,id2);
    }
    @GetMapping("/findnon/{idEtudiant}")
    public List<Equipe> findNon(@PathVariable("idEtudiant") Long id1){

        return  iEquipeService.findEquipesByEtudiantsIdEtudiantAndDetailEquipe1ThematiqueNotNull(id1);
    }

    @DeleteMapping("/delQ/{niveau}")
    public  void  DelEqp(@PathVariable Niveau niveau){
       iEquipeService.deleteEquipeByNiveau(niveau);
    }

    @GetMapping("/EqpQ/{niveau}/{thematique}")
    public List<Equipe> GeteqpQu(@PathVariable Niveau niveau,@PathVariable String thematique){

        return  iEquipeService.retriveEquipeByNiveauAndThematique(niveau,thematique);
    }


 /*   @GetMapping("/findIdEtudiantNonNull/{idEtudiant}")
    public List<Equipe> findEtudiantbyIdNonNull(@PathVariable("idEtudiant") Long id){

        return  iEquipeService.findEquipeByEtudiantsAndDetailEquipe1ThematiqueNonNull(id);
    }*/
    /*@DeleteMapping("/delDetEquipe/{IdEquipe}")
    public  void deleteEqp(@PathVariable("IdEquipe") Long id){

        iEquipeService.deleteeqp(id);
    }*/
}
