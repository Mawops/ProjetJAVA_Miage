package jeu;
import java.util.*;

public class Jeu {
	
    private GUI gui; 
	private Zone zoneCourante;
	private Joueur joueur;
	private static int nombreIndice = 10;
<<<<<<< Updated upstream

	private Zone [] lesZones = new Zone[11];
    private ArrayList<PNJ> lesPnj = new ArrayList<PNJ>();

=======
    private ArrayList<PNJ> lesPnj = new ArrayList<PNJ>();
    
>>>>>>> Stashed changes
    public Jeu() {
        creerCarte();
        creerJoueur("Camarade");
        creerPNJ();
        LierPnjToZone();

        gui = null;
    }

    public void setGUI( GUI g) { gui = g; afficherMessageDeBienvenue(); }

    private void creerJoueur(String lireNom)
    {
        joueur = new Joueur(lireNom);
    }

    //Ajout des PNJ aux zones au lancement du jeu
    private void LierPnjToZone()
    {
        lesZones[0].ajouterPNJSurMap(lesPnj.get(2));
        lesZones[1].ajouterPNJSurMap(lesPnj.get(1));
        lesZones[2].ajouterPNJSurMap(lesPnj.get(0));
        lesZones[6].ajouterPNJSurMap(lesPnj.get(5));
        lesZones[8].ajouterPNJSurMap(lesPnj.get(4));
        //Pierre n'apparaît pas tant qu'on a pas trouver la lettre d'Agathe
    }

    private void creerCarte() {

        //Zone [] zones = new Zone [11];
        lesZones[0] = new Zone("le hall", "Couloir.jpg");
        lesZones[1] = new Zone("la salle à manger", "Escalier.jpg");
        lesZones[2] = new Zone("la salle de jeux", "SalleDeJeu.jpg");
        lesZones[3] = new Zone("la cuisine", "SalleAManger.jpg" );
        lesZones[4] = new Zone("la chambre 1", "chambre1.jpg");
        lesZones[5] = new Zone("la chambre des Duchêne", ".png");
        lesZones[6] = new Zone("la bibliothèque", ".png");
        lesZones[7] = new Zone("la salle de bain", ".png");
        lesZones[8] = new Zone("la buanderie", ".png");
        lesZones[9] = new Zone("la cave", ".png");
        lesZones[10] = new Zone("le couloir", ".jpg");

        /*rez de chaussée */
        lesZones[0].ajouteSortie(Sortie.OUEST, lesZones[1]);
        lesZones[0].ajouteSortie(Sortie.NORD, lesZones[3]);
        lesZones[0].ajouteSortie(Sortie.EST, lesZones[2]);

        lesZones[1].ajouteSortie(Sortie.EST, lesZones[0]);
        lesZones[1].ajouteSortie(Sortie.SUD, lesZones[6]);

        lesZones[2].ajouteSortie(Sortie.OUEST, lesZones[0]);
        lesZones[3].ajouteSortie(Sortie.SUD, lesZones[0]);

        /*Premier étage */
        lesZones[6].ajouteSortie(Sortie.NORD, lesZones[1]);
        lesZones[6].ajouteSortie(Sortie.SUD, lesZones[10]);

        lesZones[10].ajouteSortie(Sortie.SUD, lesZones[7]);
        lesZones[10].ajouteSortie(Sortie.NORD, lesZones[6]);
        lesZones[10].ajouteSortie(Sortie.OUEST, lesZones[5]);
        lesZones[10].ajouteSortie(Sortie.EST, lesZones[4]);

        lesZones[7].ajouteSortie(Sortie.NORD, lesZones[10]);
        lesZones[7].ajouteSortie(Sortie.SUD, lesZones[8]);

        lesZones[4].ajouteSortie(Sortie.OUEST, lesZones[10]);
        lesZones[5].ajouteSortie(Sortie.EST, lesZones[10]);

        /*sous-sol*/
        lesZones[8].ajouteSortie(Sortie.SUD, lesZones[7]);
        lesZones[8].ajouteSortie(Sortie.EST, lesZones[9]);
        lesZones[9].ajouteSortie(Sortie.OUEST, lesZones[8]);

        zoneCourante = lesZones[0];

        /*ajouter les indices*/
        lesZones[6].ajouteIndice(new Indices("Lettre d'amour écrite par Agathe pour un homme, autre que son mari Pierre", "Témoignage", lesZones[6]));
        lesZones[5].ajouteIndice(new Indices("Alliance de Mr Duchêne", "Alliance", lesZones[5]));
        lesZones[3].ajouteIndice(new Indices("Couteau fraîchement nettoyé et dissimulé dans le tiroir parmis les fourchettes", "Arme du crime", lesZones[3]));
        lesZones[2].ajouteIndice(new Indices("Le corps à trois plaies profondes dans le torse, " +
                "dont deux dans le ventre et une dans la poitrine. De plus l'alliance de Mr Duchêne est manquante", "Observation du corps", lesZones[2]));

    }

    private void creerPNJ()
    {
        lesPnj.add(new PNJ("Duchêne", "...", true));
        lesPnj.add(new PNJ("Duchêne", "Mon pauvre mari... Je.. Je suis anéantie, nous venons à peine de nous marier... Il était proche d'Agathe ces temps-ci j'étais si heureuse que nos amis s'entendent bien... L'assassin est forcément dans cette maison! TROUVEZ-LE VITE!", false));
        lesPnj.add(new PNJ("Indigo", "Le meurtrier n'est forcément pas loin! Il n'y a pas une minute à perdre!", true));
<<<<<<< Updated upstream
        lesPnj.add(new PNJ("Pierre", "Quelle terrible nouvelle. Je ne portais pas tant d'affection que celà pour M.Duchêne, mais c'était un très bon ami d'Agathe.", true));
        //Pour Pierre il faut que lorsqu'on le questionne sur sont bouton de chemise, sont témoignage change et qu'il devienne hésitant
=======

        lesPnj.add(new PNJ("Pierre", "Quelle terrible nouvelle. Je ne portais pas tant d'affection que celà pour M.Duchêne, mais c'était un très bon ami d'Agathe.", true));
        //Pour Pierre il faut que lorsqu'on le questionne sur sont bouton de chemise, sont témoignage change et qu'il devienne hésitant


        lesPnj.add(new PNJ("Pierre", "Quelle terrible nouvelle. Je ne portais pas tant d'affection que celà pour M.Duchêne, mais c'était un très bon ami d'Agathe.", true));
        //Pour Pierre il faut que lorsqu'on le questionne sur sont bouton de chemise, sont témoignage change et qu'il devienne hésitant

>>>>>>> Stashed changes
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
            gui.afficher(zoneCourante.getPNJ().toString() + " : " + zoneCourante.getDescriptionPNJ());
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
            if(zoneCourante.getIndice().getNom() == "Observation du corps") {
                zoneCourante.ajouteIndice(new Indice("Pierre a lancé une boule de billard sur la fenêtre, cette dernière s'est brisée", "Bouts de verre", zoneCourante));
                lesPnj.get(2).setTemoignage("Mr Duchêne a été tué par arme tranchante!");
            }
                else if(zoneCourante.getIndice().getNom() == "Bouts de verre")
            {
                zoneCourante.ajouteIndice(new Indice("Vous avez trouvé un bouton de chemise sous la table de billard. " +
                        "Ce bouton ressemble comme deux gouttes d'eau à celui de Pierre, ce dernier avait un bouton manquant sur sa chemise", "Bouton de chemise", zoneCourante));
                lesPnj.get(2).setTemoignage("Il jouait avec Pierre, ceci est bisarre ..");
            }
            else if(zoneCourante.getIndice().getNom() == "Arme du crime")
                lesPnj.get(1).setTemoignage("Une arme ??? Le coupable doit etre cette garce d'Agathe!");

            else if(zoneCourante.getIndice().getNom() == "Témoignage")
            {
                lesPnj.get(3).setTemoignage("Je.... je comprends pas cette lettre . Certes ce mec n'etait pas tellement mon ami ...  ");
                gui.afficher("il manque quelque chose dans sa chemise...");
            }
            else if(zoneCourante.getIndice().getNom() == "Alliance")
                gui.afficher("Mme Duchêne est suspecte");
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
