package tn.esprit.projet.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reclamation implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    //primary generate auto value
    @Column(name="idReclamation")
    private Long idReclamation;
    @Temporal(TemporalType.DATE)
    @Column(name="dateReclamation")
    private Date dateReclamation;
    @Column(name="description")
    private String description;

}
