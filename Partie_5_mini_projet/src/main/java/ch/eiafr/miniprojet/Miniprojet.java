package ch.eiafr.miniprojet;



import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.rdf4j.common.iteration.Iterations;
import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.LinkedHashModel;
import org.eclipse.rdf4j.model.vocabulary.RDF;
import org.eclipse.rdf4j.model.vocabulary.RDFS;
import org.eclipse.rdf4j.model.vocabulary.XMLSchema;
import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.RepositoryResult;
import org.eclipse.rdf4j.repository.sail.SailRepository;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.Rio;
import org.eclipse.rdf4j.sail.memory.MemoryStore;

public class Miniprojet {

	
	private static String namespace = "http://eia-fr.ch/";

	

	private static IRI 	Ville, Pays, Personne, Societe, Stand, Benevole, 
						Employe, Vigneron, Association, Domaine_viticole;

	private static IRI 	se_trouve_dans, habite_a, se_situe_a, a_un, est_membre_de, travaille_pour, fait_partie_de;
		
	private static IRI 	nom, npa, code, prenom, raison_sociale, prix, surface, role, mail, annees_service,
						titre, age, annees_expericence, nb_membres, annee_creation; 
	
	private static IRI  le_landeron, neuveville, suisse, france, stand_1, stand_2,  
						street_hockey, cave_de_berne, fred, ed, gwen, anita, hubert, claude ;
	



	
	static void buildOntology(Repository rep) {
				
		RepositoryConnection conn = rep.getConnection();
		ValueFactory f = rep.getValueFactory();

		
		// IRI 
		Ville = f.createIRI(namespace, "Ville");
		Pays = f.createIRI(namespace, "Pays");
		Personne = f.createIRI(namespace, "Personne");
		Societe = f.createIRI(namespace, "Societe");
		Stand = f.createIRI(namespace, "Stand");
		Benevole = f.createIRI(namespace, "Benevole");
		Employe = f.createIRI(namespace, "Employe");
		Vigneron = f.createIRI(namespace, "Vigneron");
		Association = f.createIRI(namespace, "Association");
		Domaine_viticole = f.createIRI(namespace, "Domaine_viticole");
		

		se_trouve_dans = f.createIRI(namespace, "se_trouve_dans");
		habite_a = f.createIRI(namespace, "habite_a");
		se_situe_a = f.createIRI(namespace, "se_situe_a");
		a_un = f.createIRI(namespace, "a_un");
		est_membre_de = f.createIRI(namespace, "est_membre_de");
		travaille_pour = f.createIRI(namespace, "travaille_pour");
		fait_partie_de = f.createIRI(namespace, "fait_partie_de");
		
		

		nom = f.createIRI(namespace, "nom");
		npa = f.createIRI(namespace, "npa");
		code = f.createIRI(namespace, "code");
		prenom = f.createIRI(namespace, "prenom");
		raison_sociale = f.createIRI(namespace, "raison_sociale");
		prix = f.createIRI(namespace, "prix");
		surface = f.createIRI(namespace, "surface");
		role = f.createIRI(namespace, "role");
		mail = f.createIRI(namespace, "mail");
		annees_service = f.createIRI(namespace, "annees_service");
		titre = f.createIRI(namespace, "titre");
		age = f.createIRI(namespace, "age");
		annees_expericence = f.createIRI(namespace, "annees_expericence");
		nb_membres = f.createIRI(namespace, "nb_membres");
		annee_creation = f.createIRI(namespace, "annee_creation");
		


		le_landeron = f.createIRI(namespace, "le_landeron"); 
		neuveville = f.createIRI(namespace, "neuveville"); 
		suisse = f.createIRI(namespace, "suisse"); 
		france = f.createIRI(namespace, "france"); 
		stand_1 = f.createIRI(namespace, "stand_1"); 
		stand_2 = f.createIRI(namespace, "stand_2"); 
		street_hockey = f.createIRI(namespace, "street_hockey"); 
		cave_de_berne = f.createIRI(namespace, "cave_de_berne"); 
		fred = f.createIRI(namespace, "fred"); 
		ed = f.createIRI(namespace, "ed"); 
		gwen = f.createIRI(namespace, "gwen"); 
		anita = f.createIRI(namespace, "anita"); 
		hubert = f.createIRI(namespace, "hubert"); 
		claude = f.createIRI(namespace, "claude"); 
		
	
		
		
		try {
			// class
			conn.add(Ville, RDF.TYPE, RDFS.CLASS);
			conn.add(Pays, RDF.TYPE, RDFS.CLASS);
			conn.add(Personne, RDF.TYPE, RDFS.CLASS);
			conn.add(Societe, RDF.TYPE, RDFS.CLASS);
			conn.add(Stand, RDF.TYPE, RDFS.CLASS);
			conn.add(Benevole, RDF.TYPE, RDFS.CLASS);
			conn.add(Employe, RDF.TYPE, RDFS.CLASS);
			conn.add(Vigneron, RDF.TYPE, RDFS.CLASS);
			conn.add(Association, RDF.TYPE, RDFS.CLASS);
			conn.add(Domaine_viticole, RDF.TYPE, RDFS.CLASS);
			
			// subclass
			conn.add(Benevole, RDFS.SUBCLASSOF, Personne);
			conn.add(Employe, RDFS.SUBCLASSOF, Personne);
			conn.add(Vigneron, RDFS.SUBCLASSOF, Personne);
			conn.add(Association, RDFS.SUBCLASSOF, Societe);
			conn.add(Domaine_viticole, RDFS.SUBCLASSOF, Societe);
			
			// predicate
			conn.add(se_trouve_dans, RDF.TYPE, RDF.PREDICATE);
			conn.add(habite_a, RDF.TYPE, RDF.PREDICATE);
			conn.add(se_situe_a, RDF.TYPE, RDF.PREDICATE);
			conn.add(a_un, RDF.TYPE, RDF.PREDICATE);
			conn.add(est_membre_de, RDF.TYPE, RDF.PREDICATE);
			conn.add(travaille_pour, RDF.TYPE, RDF.PREDICATE);
			conn.add(fait_partie_de, RDF.TYPE, RDF.PREDICATE);
			

			// subProperty
			conn.add(est_membre_de, RDFS.SUBPROPERTYOF, fait_partie_de);
			conn.add(travaille_pour, RDFS.SUBPROPERTYOF, fait_partie_de);
			
			
					
			
		} finally {
			conn.close();
		}
	}
	
	
	

	
	static void createIndividualsVille(Repository rep, String nom, Integer npa, IRI iri) {
		
		RepositoryConnection conn = rep.getConnection();
		ValueFactory f = rep.getValueFactory();
		try {
			conn.add(iri, RDF.TYPE, Ville);
			conn.add(iri, Miniprojet.nom, f.createLiteral(nom, XMLSchema.STRING));
			conn.add(iri, Miniprojet.npa, f.createLiteral(npa));
		} finally {
			conn.close();
		}
	}
	
	
	static void createIndividualsPays(Repository rep, String nom, String code, IRI iri) {
		
		RepositoryConnection conn = rep.getConnection();
		ValueFactory f = rep.getValueFactory();
		try {
			conn.add(iri, RDF.TYPE, Pays);
			conn.add(iri, Miniprojet.nom, f.createLiteral(nom, XMLSchema.STRING));
			conn.add(iri, Miniprojet.code, f.createLiteral(nom, XMLSchema.STRING));
		} finally {
			conn.close();
		}
	}

	
	static void createIndividualsStand(Repository rep, String surface, String prix, IRI iri) {
		
		RepositoryConnection conn = rep.getConnection();
		ValueFactory f = rep.getValueFactory();
		try {
			conn.add(iri, RDF.TYPE, Stand);
			conn.add(iri, Miniprojet.surface, f.createLiteral(surface, XMLSchema.STRING));
			conn.add(iri, Miniprojet.prix, f.createLiteral(prix, XMLSchema.STRING));
		} finally {
			conn.close();
		}
	}

	
	static void createIndividualsBenevole(Repository rep, String role, String mail, IRI iri) {
		
		RepositoryConnection conn = rep.getConnection();
		ValueFactory f = rep.getValueFactory();
		try {
			conn.add(iri, RDF.TYPE, Stand);
			conn.add(iri, Miniprojet.role, f.createLiteral(role, XMLSchema.STRING));
			conn.add(iri, Miniprojet.mail, f.createLiteral(mail, XMLSchema.STRING));
		} finally {
			conn.close();
		}
	}

	
	static void createIndividualsEmploye(Repository rep, Integer annees_service, String titre, IRI iri) {
		
		RepositoryConnection conn = rep.getConnection();
		ValueFactory f = rep.getValueFactory();
		try {
			conn.add(iri, RDF.TYPE, Stand);
			conn.add(iri, Miniprojet.annees_service, f.createLiteral(annees_service));
			conn.add(iri, Miniprojet.titre, f.createLiteral(titre, XMLSchema.STRING));
		} finally {
			conn.close();
		}
	}

	
	static void createIndividualsVigneron(Repository rep, Integer age, Date annees_experience, IRI iri) {
		
		RepositoryConnection conn = rep.getConnection();
		ValueFactory f = rep.getValueFactory();
		try {
			conn.add(iri, RDF.TYPE, Stand);
			conn.add(iri, Miniprojet.age, f.createLiteral(age));
			conn.add(iri, Miniprojet.annees_expericence, f.createLiteral(annees_experience));
		} finally {
			conn.close();
		}
	}

	
	static void createIndividualsAssociation(Repository rep, Integer nb_membres, Date annee_creation, IRI iri) {
		
		RepositoryConnection conn = rep.getConnection();
		ValueFactory f = rep.getValueFactory();
		try {
			conn.add(iri, RDF.TYPE, Stand);
			conn.add(iri, Miniprojet.nb_membres, f.createLiteral(nb_membres));
			conn.add(iri, Miniprojet.annee_creation, f.createLiteral(annee_creation));
		} finally {
			conn.close();
		}
	}

	
	static void createIndividualsDomaineViticole(Repository rep, String surface, Date annee_creation, IRI iri) {
		
		RepositoryConnection conn = rep.getConnection();
		ValueFactory f = rep.getValueFactory();
		try {
			conn.add(iri, RDF.TYPE, Stand);
			conn.add(iri, Miniprojet.nb_membres, f.createLiteral(surface));
			conn.add(iri, Miniprojet.surface, f.createLiteral(surface, XMLSchema.STRING));
			conn.add(iri, Miniprojet.annee_creation, f.createLiteral(annee_creation));
		} finally {
			conn.close();
		}
	}
	


	
	static void createIndividuals(Repository rep) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		java.util.Date claude_date;
		java.util.Date hubert_date;
		java.util.Date street_hockey_date;
		java.util.Date cave_de_berne_date;
		try {
			 claude_date = sdf.parse("1983");
			 hubert_date = sdf.parse("1979");
			 street_hockey_date = sdf.parse("2009");
			 cave_de_berne_date = sdf.parse("1834");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		createIndividualsVille(rep, "Le Landeron", 2525,  le_landeron); 
		createIndividualsVille(rep, "La Neuveville", 2520,  neuveville);
		createIndividualsPays(rep, "Suisse", "CH",  suisse);
		createIndividualsPays(rep, "France", "FR",  france);
		createIndividualsBenevole(rep, "Graphiste", "ed@street-hockey.ch", ed);
		createIndividualsBenevole(rep, "Caissier", "fred@street-hockey.ch", fred);
		createIndividualsEmploye(rep, 3, "Secrétaire",  gwen);
		createIndividualsEmploye(rep, 7, "Vendeuse",  anita);
		createIndividualsVigneron(rep, 56, hubert_date,  hubert);
		createIndividualsVigneron(rep, 45, claude_date,  claude);
		createIndividualsStand(rep, "35", "700",  stand_1);
		createIndividualsStand(rep, "28", "560",  stand_2);
		createIndividualsAssociation(rep, 12, street_hockey_date, street_hockey);
		createIndividualsDomaineViticole(rep, "12000", cave_de_berne_date, cave_de_berne);

		}
	
	

	static void linkIndividuals(Repository rep) {
		
		
		RepositoryConnection conn = rep.getConnection();
		ValueFactory f = rep.getValueFactory();
		try {
			conn.add(le_landeron, Miniprojet.se_trouve_dans, suisse);
			conn.add(neuveville, Miniprojet.se_trouve_dans, suisse);

			conn.add(street_hockey, Miniprojet.se_trouve_dans, stand_1);
			conn.add(cave_de_berne, Miniprojet.se_trouve_dans, stand_2);

			conn.add(fred, Miniprojet.est_membre_de, street_hockey);
			conn.add(ed, Miniprojet.est_membre_de, street_hockey);

			conn.add(gwen, Miniprojet.travaille_pour, cave_de_berne);
			conn.add(anita, Miniprojet.travaille_pour, cave_de_berne);
			conn.add(hubert, Miniprojet.travaille_pour, cave_de_berne);
			conn.add(claude, Miniprojet.travaille_pour, cave_de_berne);

			conn.add(ed, Miniprojet.habite_a, neuveville);
			conn.add(gwen, Miniprojet.habite_a, neuveville);
			conn.add(anita, Miniprojet.habite_a, neuveville);
			conn.add(hubert, Miniprojet.habite_a, neuveville);
			conn.add(claude, Miniprojet.habite_a, neuveville);
			conn.add(ed, Miniprojet.habite_a, le_landeron);

			conn.add(street_hockey, Miniprojet.se_situe_a, neuveville);
			conn.add(cave_de_berne, Miniprojet.se_situe_a, neuveville);

			conn.add(street_hockey, Miniprojet.a_un, stand_1);
			conn.add(cave_de_berne, Miniprojet.a_un, stand_2);
			
			
			
			
			
		} finally {
			conn.close();
		}
	}
	
	
	
	static void displayRepositoryTurtleFormat(Repository rep) {
	
		RepositoryConnection conn = rep.getConnection();
		
		RepositoryResult<Statement> statements = conn.getStatements (null, null, null, true);
		Model model = Iterations.addAll(statements, new LinkedHashModel());	

		model.setNamespace("ns", namespace);
		model.setNamespace("rdf", RDF.NAMESPACE);
		model.setNamespace("rdfs", RDFS.NAMESPACE);
		model.setNamespace("xsd", XMLSchema.NAMESPACE);
		
		Rio.write(model, System.out, RDFFormat.TURTLE);
	}
		

	
	public static void main(String[] args) {
		
		Repository rep = new SailRepository(new MemoryStore());
		
		try {
			buildOntology(rep);
			createIndividuals(rep);
			linkIndividuals(rep);
		} finally {
			
		}	

	}

}

	
