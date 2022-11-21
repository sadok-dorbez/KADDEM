package tn.espritSpring.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.espritSpring.DAO.entites.Etudinat;
import tn.espritSpring.services.IEtudiantService;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
@RequiredArgsConstructor
public class EtudiantController {

   public final IEtudiantService iEudiantService;


    @GetMapping("/getAllEtudaints")
    public List<Etudinat> getAllEtudaint() {
        return iEudiantService.getAllEtudiant();
    }

    @PostMapping("/addEtudaint")

    public Etudinat addEtudiant(@RequestBody Etudinat e) {
        return iEudiantService.addEtudiant(e);
    }


    //Affectation Equipe au etudiant

    @PutMapping("/assignEtudiantEquipe/{idEtudiant}/{idEquipe}")
    @ResponseBody
    public void assignetu(@PathVariable("idEtudiant") Integer idEtudiant , @PathVariable("idEquipe") Integer idEquipe)
    {
        iEudiantService.assignEtudiantToEquipe(idEtudiant,idEquipe);
    }

    //Affectation Etudiant Contrat
    @PutMapping("/updateEtutiant/{idEtudiant}/{idContart}")
    public void updateEtudiant(@PathVariable ("idEtudiant") Integer idEtudiant ,@PathVariable ("idContart") Integer idContart )
    { iEudiantService.assignContratToEtudiant(idEtudiant,idContart);}

    //Affectation Etudiant Contrat Equipe
    @PutMapping("/assignEtudiant/{idContart}/{idEquipe}")
    public  Etudinat addAndAssignEtudiantToEquipeAndContract
            (@RequestBody Etudinat e,@PathVariable("idContart") Integer idContart, @PathVariable("idEquipe") Integer idEquipe){
        return iEudiantService.addAndAssignEtudiantToEquipeAndContract(e,idContart,idEquipe);
    }


    @DeleteMapping("/delete/{idEtudiant}")
    public void deleteEtudiant(@PathVariable("idEtudiant") int idEtudiant) {
        iEudiantService.deleteEtudiant(idEtudiant);
    }

    @GetMapping("/getbyid/{idEtudiant}")
    public Etudinat getEtudiantById(@PathVariable("idEtudiant") int idEtudiant) {
        return iEudiantService.getEtudiantById(idEtudiant);
    }


    @GetMapping("/retrieve-etudiant/{idUniv}")
    @ResponseBody
    public Etudinat retrieveEtudiant(@PathVariable("idUniv")Integer idContart){
        return iEudiantService.retrieveEtudiant(idContart);
    }


    @GetMapping("/getByDep/{name}")
    public List<Etudinat> getByname(@PathVariable("name") String name){
        return iEudiantService.retriveEtudiantByDepartementName(name);
    }




}
