package tn.esprit.projet.entities;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table( name = "Universite")

@Getter
@Setter
public class Universite   implements Serializable{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idUni")
    private Long idUni; // Clé primaire
    private String nomUni;
    private String Adresse;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Departement> departement;


}
