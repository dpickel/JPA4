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
import fr.codevallee.formation.tp.modele.Maire;
import fr.codevallee.formation.tp.modele.Personne;
import fr.codevallee.formation.tp.modele.Projet;
import freemarker.template.Configuration;
import freemarker.template.Version;
import spark.ModelAndView;
import spark.servlet.SparkApplication;
import spark.template.freemarker.FreeMarkerEngine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Router implements SparkApplication {

	public void init() {
	
final Logger logger = LoggerFactory.getLogger(Router.class);

		
		get("/exemple1", (request, response) -> {

			logger.debug("start");

			Map<String, Object> attributes = new HashMap<>();

			// Exemple 1 (à déplacer dans une classe statique !):
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("formation");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			
			TypedQuery<Maire> query = entityManager.createQuery("from Maire", Maire.class);
			query.getResultList();
			//attributes.put("objet", query.getResultList());
			
			entityManager.close();

			return new ModelAndView(attributes, "home.ftl");
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