package tn.espritSpring.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.espritSpring.DAO.entites.Universite;
import tn.espritSpring.services.IUniversiteService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class UniversiteController {



    IUniversiteService iUniversiteService;

    @GetMapping("/allUni")
    public List<Universite> GetUni(){

        return  iUniversiteService.getAllUniv();
    }
    @PostMapping("/addUni")
    public void  addUniv(@RequestBody Universite D){
       iUniversiteService.addUniv(D);
    }


    @PutMapping("/putUni/{idUni}")
    public void updateUni(@PathVariable("idUni") Long id, @RequestBody Universite E){

        E.setIdUni(id);
        iUniversiteService.updateUni(E);
    }
    @DeleteMapping("/delUni/{idUni}")
    public  void deleteUni(@PathVariable("idUni") Long id){

     iUniversiteService.deleteUni(id);
    }
    @GetMapping("/universite/{idUni}")

    public Universite getUniversiteById(@PathVariable("idUni") Long idUni) {
        return iUniversiteService.getUnid(idUni);
    }
    @PostMapping("/addUniDep/{idUni}/{idDepart}")
    public void  addUnivtoDep(@PathVariable("idUni") Long idU,@PathVariable("idDepart") Long id){
        iUniversiteService.assignDepartToUni(idU, id);
    }
    //nombre universite par universite
    @GetMapping("/nbDepartment/{idUni}")
    public long getnbrDepartmentByuniver(@PathVariable("idUni") Long idUni) {
        return iUniversiteService.nbTotalDepartment(idUni);
    }
 /*   @GetMapping("/nbDepartmentbynom/{nomUniv}")
    public List getnbrDepartmentBynom(@PathVariable("nomUniv") String  nomUniv) {
        return iUniversiteService.nbTotalDepartmentbynom(nomUniv);
    }
*/
}
