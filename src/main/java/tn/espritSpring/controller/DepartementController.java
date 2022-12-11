package tn.espritSpring.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.espritSpring.DAO.entites.Departement;
import tn.espritSpring.services.IDepartementService;
import tn.espritSpring.services.IUniversiteService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

@AllArgsConstructor
public class DepartementController {

    IDepartementService iDepartementService;
    IUniversiteService iUniversiteService;

    @GetMapping("/getD")
    public List<Departement> GetDep(){

        return  iDepartementService.getAlldep();
    }

    @PostMapping("/addDep")
    public void  addDepartment(@RequestBody Departement D){
        iDepartementService.addep(D);
    }


    @PutMapping("/putDep/{idDepart}")
    public void updateDepartment(@PathVariable("idDepart") Long id, @RequestBody Departement C){

        C.setIdDepart(id);
        iDepartementService.updatedep(C);
    }

    @PutMapping("/putDepatement")
    @ResponseBody
    public Departement modifyDepartment(@RequestBody Departement d) {
        return iDepartementService.updatedep(d);
    }




    @DeleteMapping("/delDep/{idDepart}")
    public  void deleteDepartment(@PathVariable("idDepart") Long id){

        iDepartementService.deletedep(id);
    }
    @GetMapping("/department/{idDepart}")

    public Departement getDepartmentById(@PathVariable("idDepart") Long idDepart) {
        return iDepartementService.getdepbyid(idDepart);
    }


    @GetMapping("/getIDU/{nomUni}")
    public List<Departement> GetDepByIdUni(@PathVariable("nomUni") String nomUni){

        return  iDepartementService.findDepartementsBynomUniversite(nomUni);
    }
    //nombre d'etudiant par department
    @GetMapping("/nbEtudiant/{idDepart}")
    @ResponseBody
    public long getnbrEtudiantByDepart(@PathVariable("idDepart") Long idDepart) {
        return iDepartementService.nbTotalEtudiant(idDepart);
    }
//nombre universite par universite


@PostMapping("/Universite/{idUni}/Departments")
public Departement createDepartment(@PathVariable(value = "idUni") Long idUni,@RequestBody Departement d) {

      return   iDepartementService.createUniver(idUni,d);
    }
    @RequestMapping(value="/univ/{idUni}/depart",method={RequestMethod.DELETE, RequestMethod.GET})
    public ResponseEntity<List<Departement>> deleteAllDepartmentOfUniversite(@PathVariable(value = "idUni") Long idUni)

    {
        return iDepartementService.deleteAllDepartmentOfUniversite(idUni);
    }

    @GetMapping("/universite/{idUni}/departments/")
    public ResponseEntity<List<Departement>> getAllDepartmentOfUniversite(@PathVariable(value = "idUni")  Long idUni) {


        return iDepartementService.getAllDepartmentOfUniversite(idUni);
    }
    @GetMapping("/getdepartbyUniv/{nomUni}")
    public List Getdepart(@PathVariable("nomUni")String nomUni){
        return iDepartementService.getNomsdepartbyidUniv(nomUni);
    }



}
