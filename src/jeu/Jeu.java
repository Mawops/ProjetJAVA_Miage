package jeu;
public class Jeu {
	
    private GUI gui; 
	private Zone zoneCourante;
	private Joueur joueur;
	private static int nombreIndice = 10;
    
    public Jeu() {
        creerCarte();
        creerJoueur("Camarade");
        gui = null;
    }

    public void setGUI( GUI g) { gui = g; afficherMessageDeBienvenue(); }

    private void creerJoueur(String lireNom)
    {
        joueur = new Joueur(lireNom);
    }

    private void creerCarte() {

        Zone [] zones = new Zone [10];
        zones[0] = new Zone("le hall", "Couloir.jpg");
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

    private void creerPNJ()
    {

    }

    private void afficherLocalisation() {
            gui.afficher( zoneCourante.descriptionLongue());
            gui.afficher();
    }

    private void afficherMessageDeBienvenue() {
    	gui.afficher("Bienvenue " + joueur.getNom() + " !");
    	gui.afficher();
        gui.afficher("Tapez '?' pour obtenir de l'aide.");
        gui.afficher();
        gui.afficher("Il y a eu un meurtre dans le manoir de Mr et Mme Duchêne, et tu vas m'aider à le résoudre !");
        gui.afficher();
        gui.afficher("Allons récupérer les clé du manoir au concierge.");
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
            parler();
            break;
         case "RECHERCHER" : case "R" :
            rechercher();
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
        return joueur.getNbIndice() == nombreIndice;
    }

    private void resoudreEnquete(String lireNom, String lireArme)
    {
        int nbChance = 1;
        boolean trouve = false;

        if(verifierIndice())
        {
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
        else
        {
            gui.afficher("Vous n'avez pas récupérer tous les indices, vous ne pouvez donc pas encore résoudre l'enquête.");
        }
    }

    private void parler()
    {
        if(zoneCourante.PNJ())
        {
            Indices i = new Indices(zoneCourante.getDescriptionPNJ(), "Témoignage", zoneCourante);
            gui.afficher(zoneCourante.getDescriptionPNJ());
            joueur.ajouterIndice(i);
        }
        else gui.afficher("Il n'y a personne dans la pièce.");
    }

    private void rechercher()
    {
        if(zoneCourante.indice())
            joueur.ajouterIndice(zoneCourante.getIndice());
        else gui.afficher("Il n'y a pas d'indice dans la pièce");
    }

    private void terminer() {
    	gui.afficher( "Au revoir...");
    	gui.enable( false);
    }
}
