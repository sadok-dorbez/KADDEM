package tn.espritSpring.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import tn.espritSpring.DAO.entites.Contart;

import java.util.Date;
import java.util.List;

public interface IContartRepository extends CrudRepository<Contart , Integer> {



    @Query(value = "SELECT count(*) FROM contart c WHERE (c.date_debut_contrat > :startDate and  c.date_fin_contrat < :endDate) and c.archive=0 ",
            nativeQuery = true)
    Integer nbContratsValides(@Param("startDate") Date startDate, @Param("endDate") Date endDate);





}
