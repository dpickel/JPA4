package fr.codevallee.formation.tp;

import static spark.Spark.get;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.codevallee.formation.tp.modele.Crud;
import fr.codevallee.formation.tp.modele.Demo;
import fr.codevallee.formation.tp.modele.Personne;
import freemarker.template.Configuration;
import freemarker.template.Version;
import spark.ModelAndView;
import spark.servlet.SparkApplication;
import spark.template.freemarker.FreeMarkerEngine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Router implements SparkApplication {

	public void init() {
	
			get("/modifier.modis", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			return new ModelAndView(attributes, "modifier.ftl");
			}, getFreeMarkerEngine());

			get("/resultat", (request, response) -> {
				String nom = request.queryParams("nom");
				String prenom = request.queryParams("prenom");
				String civilite = request.queryParams("civilite");
			
			Map<String, Object> attributes = new HashMap<>();

			// Exemple 1 (à déplacer dans une classe statique !):
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("formation");
			EntityManager entityManager = entityManagerFactory.createEntityManager();

			// J'ajoute un métier :
			//Demo metier = new Demo();
			//metier.setNom("exemple1");

			// J'ajoute une nouvelle personne
			
			Personne personne = new Personne();
			personne.setCivilite(civilite);
			personne.setNom(nom);
			personne.setPrenom(prenom);;

			Crud crud = new Crud();
			crud.Create(entityManager, personne);
			
//			entityManager.getTransaction().begin();
//			entityManager.persist(personne);
//			entityManager.getTransaction().commit();
			//entityManager.close();
			
			// Ajout pour TP3
			
			//TypedQuery<Demo> query = entityManager.createQuery("from Demo", Demo.class);
//			TypedQuery<Personne> query = entityManager.createQuery("from Personne", Personne.class);
//			
//			attributes.put("objets", query.getResultList());
			crud.Read(attributes, entityManager);
			entityManager.close();

			return new ModelAndView(attributes, "resultat.ftl");
		}, getFreeMarkerEngine());

	}

	private FreeMarkerEngine getFreeMarkerEngine() {
		FreeMarkerEngine engine = new FreeMarkerEngine();
		Configuration configuration = new Configuration(new Version(2, 3, 23));
		configuration.setTemplateUpdateDelayMilliseconds(Long.MAX_VALUE);
		configuration.setClassForTemplateLoading(FreeMarkerEngine.class, "");
		engine.setConfiguration(configuration);
		return engine;
	}

}