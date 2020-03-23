package jeu;
import java.util.*;
<<<<<<< HEAD

=======
>>>>>>> master
public class Jeu {
	
    private GUI gui; 
	private Zone zoneCourante;
	private Joueur joueur;
	private static int nombreIndice = 10;
<<<<<<< HEAD
    private ArrayList<PNJ> lesPnj = new ArrayList<PNJ>();
=======
	private ArrayList<PNJ> lesPnj = new ArrayList<PNJ>();
>>>>>>> master
    
    public Jeu() {
        creerCarte();
        creerJoueur("Camarade");
        creerPNJ();
        gui = null;
    }

    public void setGUI( GUI g) { gui = g; afficherMessageDeBienvenue(); }

    private void creerJoueur(String lireNom)
    {
        joueur = new Joueur(lireNom);
    }

    private void creerCarte() {

        Zone [] zones = new Zone [11];
        zones[0] = new Zone("le hall", "Couloir.jpg");
        zones[1] = new Zone("la salle à manger", "Escalier.jpg" );
        zones[2] = new Zone("la salle de jeux", "SalleDeJeu.jpg" );
        zones[3] = new Zone("la cuisine", "SalleAManger.jpg" );
        zones[4] = new Zone("la chambre 1", "chambre1.jpg");
        zones[5] = new Zone("la chambre des Duchêne", ".png");
        zones[6] = new Zone("la bibliothèque", ".png");
        zones[7] = new Zone("la salle de bain", ".png");
        zones[8] = new Zone("la buanderie", ".png");
        zones[9] = new Zone("la cave", ".png");
        zones[10] = new Zone("le couloir", ".jpg");

        /*rez de chaussée */
        zones[0].ajouteSortie(Sortie.OUEST, zones[1]);
        zones[0].ajouteSortie(Sortie.NORD, zones[3]);
        zones[0].ajouteSortie(Sortie.EST, zones[2]);

        zones[1].ajouteSortie(Sortie.EST, zones[0]);
        zones[1].ajouteSortie(Sortie.SUD, zones[6]);

        zones[2].ajouteSortie(Sortie.OUEST, zones[0]);
        zones[3].ajouteSortie(Sortie.SUD, zones[0]);

        /*Premier étage */
        zones[6].ajouteSortie(Sortie.NORD, zones[1]);
        zones[6].ajouteSortie(Sortie.SUD, zones[10]);

        zones[10].ajouteSortie(Sortie.SUD, zones[7]);
        zones[10].ajouteSortie(Sortie.NORD, zones[6]);
        zones[10].ajouteSortie(Sortie.OUEST, zones[5]);
        zones[10].ajouteSortie(Sortie.EST, zones[4]);

        zones[7].ajouteSortie(Sortie.NORD, zones[10]);
        zones[7].ajouteSortie(Sortie.SUD, zones[8]);

        zones[4].ajouteSortie(Sortie.OUEST, zones[10]);
        zones[5].ajouteSortie(Sortie.EST, zones[10]);

        /*sous-sol*/
        zones[8].ajouteSortie(Sortie.SUD, zones[7]);
        zones[8].ajouteSortie(Sortie.EST, zones[9]);
        zones[9].ajouteSortie(Sortie.OUEST, zones[8]);

        zoneCourante = zones[0];

        /*ajouter les indices*/
        zones[6].ajouteIndice(new Indices("Lettre d'amour écrite par Agathe pour un homme, autre que son mari Pierre", "Témoignage", zones[6]));
        zones[5].ajouteIndice(new Indices("Alliance de Mr Duchêne", "Alliance", zones[5]));
        zones[3].ajouteIndice(new Indices("Couteau fraîchement nettoyé et dissimulé dans le tiroir parmis les fourchettes", "Arme du crime", zones[3]));
        zones[2].ajouteIndice(new Indices("Le corps à trois plaies profondes dans le torse, " +
                "dont deux dans le ventre et une dans la poitrine. De plus l'alliance de Mr Duchêne est manquante", "Observation du corps", zones[2]));

    }

    private void creerPNJ()
    {
        lesPnj.add(new PNJ("Duchêne", "...", true));
        //lesPnj.get(0).setEmplacement(); //Je doit récupérer le tableau de zone pour attribuer une zone a chaque PNJ
        lesPnj.add(new PNJ("Duchêne", "Mon pauvre mari... Je.. Je suis anéantie, nous venons à peine de nous marier... Il était proche d'Agathe ces temps-ci j'étais si heureuse que nos amis s'entendent bien... L'assassin est forcément dans cette maison! TROUVEZ-LE VITE!", false));
        lesPnj.add(new PNJ("Indigo", "Le meurtrier n'est forcément pas loin! Il n'y a pas une minute à perdre!", true));
<<<<<<< HEAD

        lesPnj.add(new PNJ("Pierre", "Quelle terrible nouvelle. Je ne portais pas tant d'affection que celà pour M.Duchêne, mais c'était un très bon ami d'Agathe.", true));
        //Pour Pierre il faut que lorsqu'on le questionne sur sont bouton de chemise, sont témoignage change et qu'il devienne hésitant

=======

        lesPnj.add(new PNJ("Pierre", "Quelle terrible nouvelle. Je ne portais pas tant d'affection que celà pour M.Duchêne, mais c'était un très bon ami d'Agathe.", true));
        //Pour Pierre il faut que lorsqu'on le questionne sur sont bouton de chemise, sont témoignage change et qu'il devienne hésitant

>>>>>>> master
        lesPnj.add(new PNJ("Père Kent", "M'sieur, depuis ce midi je suis dans le jardin, regardez mon accoutrement, il est plein de boue! Je suis monté chercher des affaires dans la salle de jeu et c'est là que j'ai découvert le corps sans vie.", true));
        lesPnj.add(new PNJ("Agathe", "OH MON DIEU! Qui aurais pu en vouloir à ce pauvre M.Duchêne, il était si gentil, beau, intelligent.. euh.. Bref bougez vous de trouver le meurtrier!", false));
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
	gui.afficher("Ensuite aller à la salle de jeu (à l'est) pour examiner le corps du cadavre");
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
                    gui.afficher("Bravo vous avez réussi à résoudre l'enquête !");
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
        {
            joueur.ajouterIndice(zoneCourante.getIndice());
            gui.afficher("Vous venez de récupérer un indice : " + zoneCourante.getIndice().getDescription());
            if(zoneCourante.getIndice().getNom() == "Observation du corps")
                zoneCourante.ajouteIndice(new Indices("Pierre a lancé une boule de billard sur la fenêtre, cette dernière s'est brisée", "Bouts de verre", zoneCourante));
            else if(zoneCourante.getIndice().getNom() == "Bouts de verre")
                zoneCourante.ajouteIndice(new Indices("Vous avez trouvé un bouton de chemise sous la table de billard. " +
                        "Ce bouton ressemble comme deux gouttes d'eau à celui de Pierre, ce dernier avait un bouton manquant sur sa chemise", "Bouton de chemise", zoneCourante));
            else zoneCourante.indiceRecupere();
        }
        else gui.afficher("Il n'y a pas d'indice dans la pièce");
        gui.afficher();
    }

    private void terminer() {
    	gui.afficher( "Au revoir...");
    	gui.enable( false);
    }
}
