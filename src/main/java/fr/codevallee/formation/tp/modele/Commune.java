package fr.codevallee.formation.tp.modele;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Commune {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private long id;
	
	@Column(length = 40)
	private String nom;
	
	@OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE}, orphanRemoval=true)
	private Maire maire;

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

	/**
	 * @return the maire
	 */
	public Maire getMaire() {
		return maire;
	}

	/**
	 * @param maire the maire to set
	 */
	public void setMaire(Maire maire) {
		this.maire = maire;
	}

}
