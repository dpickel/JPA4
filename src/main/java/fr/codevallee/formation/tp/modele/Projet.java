package fr.codevallee.formation.tp.modele;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Projet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 40)
	private String nom;
	
	@ManyToMany(mappedBy = "projets", cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	private Set<Elu> elus;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the elus
	 */
	public Set<Elu> getElus() {
		return elus;
	}

	/**
	 * @param elus
	 *            the elus to set
	 */
	public void setElus(Set<Elu> elus) {
		this.elus = elus;
	}

}
