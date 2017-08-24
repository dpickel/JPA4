package fr.codevallee.formation.tp.modele;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Elu {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private long id;
	
	@Column(length = 40)
	private String nom;
	
	@ManyToMany
	private Set<Projet> projets ;

	/**
	 * @return the projets
	 */
	public Set<Projet> getProjets() {
		return projets;
	}

	/**
	 * @param projets the projets to set
	 */
	public void setProjets(Set<Projet> projets) {
		this.projets = projets;
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
