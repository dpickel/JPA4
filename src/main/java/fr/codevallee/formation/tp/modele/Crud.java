package fr.codevallee.formation.tp.modele;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class Crud {

	public void Create( EntityManager entityManager, String civilite, String nom, String prenom ){

		Personne personne = new Personne();
		personne.setCivilite(civilite);
		personne.setNom(nom);
		personne.setPrenom(prenom);
		
		entityManager.getTransaction().begin();
		entityManager.persist(personne);
		entityManager.getTransaction().commit();
		
	}
	
	public Map<String, Object>  Read( Map<String, Object> attributes, EntityManager entityManager ){
		
		TypedQuery<Personne> query = entityManager.createQuery("from Personne", Personne.class);
		attributes.put("objets", query.getResultList());
		return attributes;
		
	}
	
	public void Delete( EntityManager entityManager, String civilite, String nom, String prenom ){

		Personne personne = new Personne();
		personne = entityManager.find(Personne.class, 50);
		
		personne.setCivilite(civilite);
		personne.setNom(nom);
		personne.setPrenom(prenom);
		
		entityManager.getTransaction().begin();
		entityManager.remove(personne);
		entityManager.getTransaction().commit();
		
	}
	
}
