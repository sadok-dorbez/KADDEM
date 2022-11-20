package tn.esprit.projet.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table( name = "DetailEquipe")

@Getter
@Setter
@NoArgsConstructor
@ToString


public class DetailEquipe  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="IdEquipe")
    private Long IdEquipe;
    private Long salle;
    private String thematique;
    @OneToOne(mappedBy = "detailEquipe1")
    @JsonIgnore
    private  Equipe equipe;


}
