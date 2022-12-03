package tn.espritSpring.DAO.entites;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

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

	@Column(name="photo")
	private byte[] photo;


	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER , mappedBy="equipes")
	private Set<Etudinat> etudinats;
	
	@OneToOne
	private DetailEquipe detailEquipe;
	
	
	
	
	

}
