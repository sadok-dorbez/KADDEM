package tn.espritSpring.DAO.entites;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Equipe implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idEquipe")
	private Integer idEquipe;
	
	
	@Column(name="nomEquipe")
	private String nomEquipe;

	@Column(name="niveau")
	private Niveau niveau;

	@ManyToMany(cascade = CascadeType.PERSIST, mappedBy="equipes")
	private Set<Etudinat> etudinats;
	
	@OneToOne
	private DetailEquipe detailEquipe;
	
	
	
	
	

}
