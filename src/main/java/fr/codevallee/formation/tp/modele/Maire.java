package fr.codevallee.formation.tp.modele;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Maire {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private long id;
	
	@Column(length = 40)
	private String nom;
	
	@OneToOne( mappedBy = "maire" )
	private Commune commune;
	
	@OneToMany(cascade={CascadeType.PERSIST,CascadeType.REMOVE}, orphanRemoval=true, fetch=FetchType.LAZY)
	private Set<Elu> elu ;

	/**
	 * @return the commune
	 */
	public Commune getCommune() {
		return commune;
	}

	/**
	 * @param commune the commune to set
	 */
	public void setCommune(Commune commune) {
		this.commune = commune;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
