package tn.espritSpring.DAO.entites;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Contart implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idContart")
	private Integer idContart;

	
	@Column(name="dateDebutContrat")
	private Date dateDebutContrat;

	@Column(name="dateFinContrat")
	private Date dateFinContrat;

	@Column(name="specialite")
	private Specialite specialite;

	@Column(name="archive")
	private Boolean archive;

	@Column(name="montnatContrat")
	private Long montnatContrat;

	@ManyToOne
	private  Etudinat etudinat;
	
	
	
	
	

}
