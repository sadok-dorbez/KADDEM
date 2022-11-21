package tn.espritSpring.DAO.entites;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class DetailEquipe implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idDetailEquipe")
	private Integer idDetailEquipe;
	
	@Column(name="salle")
	private String salle;
	
	@Column(name="thematique")
	private String thematique;
	
	
	@OneToOne(mappedBy="detailEquipe")
	private Equipe equipe;
	
	
	

}
