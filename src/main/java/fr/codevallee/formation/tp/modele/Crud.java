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
	
	public void Delete( EntityManager entityManager, int id ){

		Personne personne = new Personne();
		personne = entityManager.find(Personne.class, id);

		entityManager.getTransaction().begin();
		entityManager.remove(personne);
		entityManager.getTransaction().commit();
		
	}

	public void MettreAJour(EntityManager entityManager, String civilite, String nom, String prenom, int id) {
		// TODO Auto-generated method stub
		
		Personne personne = entityManager.find(Personne.class, id);
		
		entityManager.getTransaction().begin();
		personne.setCivilite(civilite);
		personne.setNom(nom);
		personne.setPrenom(prenom);
		entityManager.getTransaction().commit();
		
	}
	
}
