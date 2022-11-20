package tn.esprit.projet.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table( name = "Contrat")
@Getter
@Setter
public class Contrat implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idContrat")
    private Long idContrat; // Clé primaire
    @Temporal (TemporalType.DATE)
    private Date DateDebutContrat;
    @Temporal (TemporalType.DATE)
    private Date DateFinContrat;
    private  boolean archive;
    @Enumerated(EnumType.STRING)
    private Specialite specialite;
    @ManyToOne(cascade = CascadeType.ALL)
    Etudiant etudiant;


// Constructeur et accesseurs (getters) et mutateurs (setters)

}
