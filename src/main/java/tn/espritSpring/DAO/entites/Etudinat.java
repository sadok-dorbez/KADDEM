package tn.espritSpring.DAO.entites;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;


@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Etudinat implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idEtudiant")
	private Integer idEtudiant;
	
	
	@Column(name="prenomE")
	private String prenomE;

	@Column(name="nomE")
	private String nomE;

	private LocalDate DateNaissance;

	private Genre genre ;

	@Column(name="photo")
	private byte[] photo;
	
	@Column(name="option")
	private Option option;

	private String email ;
	
	@OneToOne
	private Contart contrat;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Departement  departement;


	@ManyToMany(fetch = FetchType.EAGER) //(cascade = CascadeType.PERSIST)
	@JsonIgnore
	private Set<Equipe> equipes;





}
