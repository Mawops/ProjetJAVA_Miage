package jeu;
public class Jeu {
	
    private GUI gui; 
	private Zone zoneCourante;
	private Joueur joueur;
    
    public Jeu() {
        creerCarte();
        gui = null;
    }

    public void setGUI( GUI g) { gui = g; afficherMessageDeBienvenue(); }

    private void creerJoueur(String lireNom)
    {
        joueur = new Joueur(lireNom);
    }

    private void creerCarte() {

        Zone [] zones = new Zone [10];
        zones[0] = new Zone("le hall", "Couloir.jpg", new PNJ("test", "jai vu test2 faire ca dans la salla à manger"), null);
        zones[1] = new Zone("la salle à manger", "Escalier.jpg" );
        zones[2] = new Zone("la salle de jeux", "GrandeSalle.jpg" );
        zones[3] = new Zone("la cuisine", "SalleAManger.jpg" );
        zones[4] = new Zone("la chambre 1", ".png");
        zones[5] = new Zone("la chambre 2", ".png");
        zones[6] = new Zone("la bibliothèque", ".png");
        zones[7] = new Zone("la salle de bain", ".png");
        zones[8] = new Zone("la buanderie", ".png");
        zones[9] = new Zone("la cave", ".png");

        zones[0].ajouteSortie(Sortie.OUEST, zones[1]);
        zones[0].ajouteSortie(Sortie.NORD, zones[3]);
        zones[0].ajouteSortie(Sortie.EST, zones[2]);

        zones[1].ajouteSortie(Sortie.EST, zones[0]);
        zones[1].ajouteSortie(Sortie.SUD, zones[6]);

        zones[2].ajouteSortie(Sortie.OUEST, zones[1]);
        zones[3].ajouteSortie(Sortie.NORD, zones[1]);
        zoneCourante = zones[0];
    }

    private void afficherLocalisation() {
            gui.afficher( zoneCourante.descriptionLongue());
            gui.afficher();
    }

    private void afficherMessageDeBienvenue() {
    	gui.afficher("Bienvenue !");
    	gui.afficher();
        gui.afficher("Tapez '?' pour obtenir de l'aide.");
        gui.afficher();
        gui.afficher("Quel est votre nom ?");
        gui.afficher();
        afficherLocalisation();
        gui.afficheImage(zoneCourante.nomImage());
    }
    
    public void traiterCommande(String commandeLue) {
    	gui.afficher( "> "+ commandeLue + "\n");
        switch (commandeLue.toUpperCase()) {
        case "?" : case "AIDE" : 
            afficherAide(); 
        	break;
        case "N" : case "NORD" :
        	allerEn( "NORD"); 
        	break;
       case "S" : case "SUD" :
        	allerEn( "SUD"); 
        	break;
        case "E" : case "EST" :
        	allerEn( "EST"); 
        	break;
        case "O" : case "OUEST" :
        	allerEn( "OUEST"); 
        	break;
        case "Q" : case "QUITTER" :
        	terminer();
        	break;
        case "PARLER" : case "P" :
            if(zoneCourante.PNJ())
            {
                gui.afficher(zoneCourante.getDescriptionPNJ());
                joueur.ajouter(new Indices(zoneCourante.getDescriptionPNJ(), "temoignage", zoneCourante));
            }
            else gui.afficher("Il n'y a personne dans la pièce.");
            break;
         case "RECHERCHER" : case "R" :
            if(zoneCourante.indice())
                joueur.ajouter(zoneCourante.getIndice());
            else gui.afficher("Il n'y a pas d'indice dans la pièce");
            break;
       	default : 
            gui.afficher("Commande inconnue");
            break;
        }
    }

    private void afficherAide() {
        gui.afficher("Etes-vous perdu ?");
        gui.afficher();
        gui.afficher("Les commandes autorisées sont :");
        gui.afficher();
        gui.afficher(Commande.toutesLesDescriptions().toString());
        gui.afficher();
    }

    private void allerEn(String direction) {
    	Zone nouvelle = zoneCourante.obtientSortie( direction);
    	if ( nouvelle == null ) {
        	gui.afficher( "Pas de sortie " + direction);
    		gui.afficher();
    	}
        else {
        	zoneCourante = nouvelle;
        	gui.afficher(zoneCourante.descriptionLongue());
        	gui.afficher();
        	gui.afficheImage(zoneCourante.nomImage());
        }
    }

    private boolean verifierIndice()
    {
        boolean indiceVerifie = false;

        return indiceVerifie;
    }

    private void resoudreEnquete(String lireNom, String lireArme)
    {
        int nbChance = 1;
        boolean trouve = false;

        while(nbChance <= 3 && !trouve)
        {
            if((lireNom == "PIERRE") &&(lireArme == "COUTEAU"))
            {
                gui.afficher("Bravo vous avez réussi à resoudre l'enquête !");
                terminer();
                trouve = true;
            }
            else
            {
                nbChance ++;
            }
        }
        if(!trouve)
        {
            gui.afficher("Vous n'avez pas réussi à résoudre l'enquête... Dommage");
            terminer();
        }
    }

    private void parler()
    {
        if(zoneCourante.PNJ())
        {

        }
    }

    private void terminer() {
    	gui.afficher( "Au revoir...");
    	gui.enable( false);
    }
}
