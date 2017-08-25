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
			String action = request.queryParams("Action");
			String nom = request.queryParams("nom");
			String prenom = request.queryParams("prenom");
			String civilite = request.queryParams("civilite");


			Map<String, Object> attributes = new HashMap<>();

			// Exemple 1 (à déplacer dans une classe statique !):
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("formation");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			Crud crud = new Crud();
			String nom_de_fichier = "home.ftl";

			if (action.equals("Ajouter") == true) {

				crud.Create(entityManager, civilite, nom, prenom);
				nom_de_fichier = "modifier.ftl";

			}

			if (action.equals("Lire") == true) {

				attributes = crud.Read(attributes, entityManager);
				nom_de_fichier = "resultat.ftl";

			}
			
			if (action.equals("Supprimer") == true) {

				int id = Integer.parseInt( request.queryParams("Id") );
				crud.Delete(entityManager, id);
				nom_de_fichier = "modifier.ftl";

			}
			
			if (action.equals("Mettre_a_jour") == true) {

				int id = Integer.parseInt( request.queryParams("Id") );
				System.out.println("toto maj");
				crud.MettreAJour( entityManager, civilite, nom, prenom, id );
				nom_de_fichier = "modifier.ftl";

			}


			entityManager.close();

			return new ModelAndView(attributes, nom_de_fichier);
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