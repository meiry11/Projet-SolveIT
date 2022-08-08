package fr.solveit.config;


import fr.solveit.model.*;
import fr.solveit.repository.*;
import fr.solveit.service.CompteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
	@Autowired
	CompteService compteService;
	@Autowired
	IUtilisateurRepo utilisateurRepo;
	@Autowired
	ISessionRepo sessionRepo;
	@Autowired
	IMatiereRepo matiereRepo;
	@Autowired
	IFeuilleEmargementRepo feuilleEmargementRepo;
	@Autowired
	IEmploiTempsRepo emploiTempsRepo;
	@Bean
	public Matiere trouverMatiere(){
		Matiere matiere;
		matiere = matiereRepo.findById(1).get();
		return matiere;
	}
	@Bean
	public Session trouverSession(){
		Session matiere;
		matiere = sessionRepo.findById(1).get();
		return matiere;
	}
	@Bean
	public Formateur trouverFormateur(){
		Formateur matiere;
		matiere = (Formateur) utilisateurRepo.findById("179115900100113").get();
		return matiere;
	}
	@Bean
	public FeuilleEmargement trouverFeuilleEmargement(){
		FeuilleEmargement matiere;
		matiere = feuilleEmargementRepo.findById("2021802905_00").get();
		return matiere;
	}
	@Bean
	public Administration trouverAdministration(){
		Administration matiere;
		matiere = (Administration) utilisateurRepo.findById("123456").get();
		return matiere;
	}

	@Bean
	public Calendrier trouverCalendrier(ICalendrierRepo calendrierRepo){
		CalendrierId calendrierId =new CalendrierId(trouverMatiere(),trouverSession(),trouverFormateur(),trouverFeuilleEmargement(), trouverAdministration());
		Calendrier calendrier; //= new Calendrier( calendrierId,Time.valueOf("09:00:00"),Time.valueOf("11:00:00"), (java.util.Date) Date.valueOf("2021-09-16"));
		calendrier= calendrierRepo.findById(calendrierId).get();
		return calendrier;
	}
	@Bean
	public EmploiTemps trouverEmploi(){
		EmploiTempsId emploiTempsId = new EmploiTempsId((java.util.Date) Date.valueOf("2022-01-01"), (Administration) utilisateurRepo.findById("123456").get(),sessionRepo.findById(1).get()) ;
		return emploiTempsRepo.findById(emploiTempsId).get();
	}
	@Bean
	public List<Stagiaire> trouverStagiaire(){
		return null;//utilisateurRepo.findBySession(1);
	}
	@Bean
	CommandLineRunner initDatabase(ICalendrierRepo calendrierRepo){//IFeuilleEmargementRepo feuilleEmargementRepo){//) {
	//EmploiTempsId emploiTempsId = new EmploiTempsId((java.util.Date) Date.valueOf("2022-01-01"), (Administration) utilisateurRepo.findById("123456").get(),sessionRepo.findById(1).get()) ;
	//EmploiTemps emploiTemps = new EmploiTemps(emploiTempsId,"x CQP DRVL",(java.util.Date) Date.valueOf("2021-09-24"),(java.util.Date) Date.valueOf("2021-09-16"));
		//FeuilleEmargement feuilleEmargement = new FeuilleEmargement("2021802905_00","TP Mécanicien de Maintenance Automobile","SAVARY",Date.valueOf("2021-09-16"),Date.valueOf("2021-09-16"),Date.valueOf("2021-11-12"));
		//CalendrierId calendrierId =new CalendrierId(matiereRepo.findById(1).get(),sessionRepo.findById(1).get(),(Formateur) utilisateurRepo.findById("179115900100113").get(),feuilleEmargementRepo.findById("2021802905_00").get(), (Administration) utilisateurRepo.findById("123456").get());
		//Calendrier calendrier = new Calendrier( calendrierId,Time.valueOf("9:00"),Time.valueOf("11:00"), (java.util.Date) Date.valueOf("2021-09-16"));
		Session sessiom = new Session(1,"CQF",Date.valueOf("2021-09-16"),Date.valueOf("2021-09-24"));
		List<EmploiTemps> emploi = new ArrayList<>();
		List<Calendrier> calendriers = new ArrayList<>();
		List<Stagiaire> stagiaires = new ArrayList<>();
		//EmploiTempsId emploiTempsId = new EmploiTempsId((java.util.Date) Date.valueOf("2022-01-01"), (Administration) utilisateurRepo.findById("123456").get(),sessionRepo.findById(1).get()) ;
		//emploi.add(emploiTempsRepo.findById(emploiTempsId).get());
		emploi.add(trouverEmploi());

		calendriers.add(trouverCalendrier(calendrierRepo));
		stagiaires = trouverStagiaire();
		sessiom.setEmploiTemps(emploi);
		sessiom.setCalendriers(calendriers);
		sessiom.setUtilisateursNaissance(stagiaires);
		return args -> {
			//System.out.println("test"+emploiTempsRepo.save(emploiTemps));
			//System.out.println("test"+feuilleEmargementRepo.save(feuilleEmargement));
			System.out.println("test"+ utilisateurRepo.findBySession("CQF",Date.valueOf("2021-09-16"),Date.valueOf("2021-09-24")));//calendrierRepo.save(calendrier));

		};

	}
/*	@Autowired
	IMatiereRepo matiereRepo;
	@Autowired
	IVilleRepo villeRepo;

	@Autowired
	ICompteRepo compteRepo;
	@Bean
	public Ville trouverVille(){
		Ville ville;
		ville =  villeRepo.findById(7).get();
		return ville;
	}

	@Bean
	public Ville trouverVillenaissance(){
		Ville ville;
		ville =  villeRepo.findById(7).get();
		return ville;
	}

	@Bean
	public Compte trouverCompte(){
		Compte compte;
		compte = compteRepo.findById(3).get();
		return compte;
	}

	@Bean
	public Matiere trouverMatiere(){
		Matiere matiere;
		matiere = matiereRepo.findById(3).get();
		return matiere;
	}

	@Bean
	CommandLineRunner initDatabase(IUtilisateurRepo utilisateurRepo) {
		/*Formateur formateur = new Formateur();
		formateur.setNumSecu("179115900100113");
		formateur.setNom("Graiden");
		formateur.setPrenom("Newman");
		formateur.setDateNaissance(Date.valueOf("1979-11-01"));
		formateur.setAdresse("562-1139 Urna. St.");
		formateur.setCivilite("Mr");
		formateur.setCompte(trouverCompte());
		formateur.setVilleHabitation(trouverVille());
		formateur.setVilleNaissance(trouverVillenaissance());
		formateur.setMatiere(trouverMatiere());*/
/*
		return args -> {
			log.info("loading data " + utilisateurRepo.save(new Formateur("179115900100313","Richardson","Isaac",Date.valueOf("1990-01-30"),"6889 Nibh Street","Mme",trouverCompte(),trouverVille(),trouverVillenaissance(),trouverMatiere())));

		};
	}
/*
	@Bean
	CommandLineRunner initDatabase(IDepartementRepo departementeRepo) {
		return args -> {
			log.info("loading data " + departementeRepo.save(new Departement( "NORD",59,null,3)));
			log.info("loading data " + departementeRepo.save(new Departement("PAS-DE-CALAIS",62,null,3)));
			log.info("loading data " + departementeRepo.save(new Departement("Somme",80,null,3)));
			log.info("loading data " + departementeRepo.save(new Departement("Aisne",2,null,3)));
			log.info("loading data " + departementeRepo.save(new Departement("Etranger",99,109,1)));
			log.info("loading data " + departementeRepo.save(new Departement("Etranger",99,131,2)));
			log.info("loading data " + departementeRepo.save(new Departement("Etranger",99,135,4)));
			log.info("loading data " + departementeRepo.save(new Pays("Etranger",99,132,5)));
			log.info("loading data " + departementeRepo.save(new Pays("Etranger",99,127,6)));
			log.info("loading data " + departementeRepo.save(new Pays("Etranger",99,134,7)));
			log.info("loading data " + departementeRepo.save(new Pays("Etranger",99,139,8)));
			log.info("loading data " + departementeRepo.save(new Pays("Etranger",99,352,9)));
			log.info("loading data " + departementeRepo.save(new Pays("Etranger",99,350,10)));
			log.info("loading data " + departementeRepo.save(new Pays("Etranger",99,351,11)));
			log.info("loading data " + departementeRepo.save(new Pays("Etranger",99,341,12)));
		};
	}
	CommandLineRunner initDatabase(IPaysRepo paysRepo) {
		return args -> {
			log.info("loading data " + paysRepo.save(new Pays( "ALLEMAGNE", "ALL")));
			log.info("loading data " + paysRepo.save(new Pays("BELGIQUE", "BEL")));
			log.info("loading data " + paysRepo.save(new Pays("FRANCE","FR")));
			log.info("loading data " + paysRepo.save(new Pays("PAYS-BAS","PB")));
			log.info("loading data " + paysRepo.save(new Pays("ROYAUME-UNI","ENG")));
			log.info("loading data " + paysRepo.save(new Pays("ITALIE","IT")));
			log.info("loading data " + paysRepo.save(new Pays("ESPAGNE","ESP")));
			log.info("loading data " + paysRepo.save(new Pays("PORTUGAL","POR")));
			log.info("loading data " + paysRepo.save(new Pays("ALGERIE","ALG")));
			log.info("loading data " + paysRepo.save(new Pays("MAROC","MAR")));
			log.info("loading data " + paysRepo.save(new Pays("TUNISIE","TUN")));
			log.info("loading data " + paysRepo.save(new Pays("SENEGAL","SEN")));
		};
	}*/

}
