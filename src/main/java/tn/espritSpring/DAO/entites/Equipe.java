package tn.espritSpring.DAO.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	@JsonIgnore
	private byte[] photo;

	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER , mappedBy="equipes")
	@JsonIgnore
	private Set<Etudinat> etudinats;

	@OneToOne
	@JsonIgnore
	private DetailEquipe detailEquipe;

}
