package tn.espritSpring.DAO.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Departement implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idDepart")
	private Integer idDepart;
	
	@Column(name="nomDepart")
	private String nomDepart;
	
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="departement")
	private Set<Etudinat> etudiants;

}
