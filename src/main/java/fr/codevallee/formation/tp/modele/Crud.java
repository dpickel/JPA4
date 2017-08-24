package fr.codevallee.formation.tp.modele;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class Crud {

	public void Create( EntityManager entityManager, Personne personne ){

		entityManager.getTransaction().begin();
		entityManager.persist(personne);
		entityManager.getTransaction().commit();
		
	}
	
	public void Read( Map<String, Object> attributes, EntityManager entityManager ){
		
		TypedQuery<Personne> query = entityManager.createQuery("from Personne", Personne.class);
		
		attributes.put("objets", query.getResultList());
		
	}
	
}
