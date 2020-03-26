package jeu;
import java.util.*;

public class Jeu {

    //Initialisations
    private GUI gui;
	private Zone zoneCourante;
	private Joueur joueur;
	private int nombreIndice = 15;
	private Zone [] lesZones = new Zone[11];
    private ArrayList<PNJ> lesPnj = new ArrayList<PNJ>();

    /**
     * Constructeur du jeu
     */
    public Jeu() {
        creerCarte();
        creerJoueur("Camarade");
        creerPNJ();
        LierPnjToZone();

        gui = null;
    }

    /**
     *
     * @param g
     */
    public void setGUI( GUI g) { gui = g; afficherMessageDeBienvenue(); }

    /**
     *création du joueur
     * @param lireNom : nom du joueur
     */
    private void creerJoueur(String lireNom)
    {
        joueur = new Joueur(lireNom);
    }

    /**
     *Ajout des PNJ aux zones au lancement du jeu
     */
    private void LierPnjToZone()
    {
        lesZones[0].ajouterPNJSurMap(lesPnj.get(2));
        lesZones[1].ajouterPNJSurMap(lesPnj.get(1));
        lesZones[2].ajouterPNJSurMap(lesPnj.get(0));
        lesZones[6].ajouterPNJSurMap(lesPnj.get(5));
        lesZones[8].ajouterPNJSurMap(lesPnj.get(4));
        //Pierre n'apparaît pas tant qu'on a pas trouvé la lettre d'Agathe
    }

    /**
     * création de la carte :
     * création des différentes zones
     * création des liens entre les zones
     */
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
        lesZones[6].ajouteIndice(new Indices("Lettre d'amour écrite par Agathe pour un homme, autre que son mari Pierre", "Lettre d'amour", lesZones[6]));
        lesZones[5].ajouteIndice(new Indices("Alliance de Mr Duchêne", "Alliance", lesZones[5]));
        lesZones[3].ajouteIndice(new Indices("Couteau fraîchement nettoyé et dissimulé dans le tiroir, parmis les fourchettes", "Arme du crime", lesZones[3]));
        lesZones[2].ajouteIndice(new Indices("Le corps à trois plaies profondes dans le torse, " +
                "dont deux dans le ventre et une dans la poitrine. De plus l'alliance de Mr Duchêne est manquante", "Observation du corps", lesZones[2]));

    }

    /**
     * création de tous les PNJ pour le fonctionnement du jeu
     */
    private void creerPNJ()
    {
        lesPnj.add(new PNJ("Duchêne", "...", true));
        lesPnj.add(new PNJ("Duchêne", "Mon pauvre mari... Je.. Je suis anéantie, nous venons à peine de nous marier... Il était proche d'Agathe ces temps-ci j'étais si heureuse que nos amis s'entendent bien... L'assassin est forcément dans cette maison! TROUVEZ-LE VITE!", false));
        lesPnj.add(new PNJ("Indigo", "Le meurtrier n'est forcément pas loin ! Il n'y a pas une minute à perdre!", true));

        lesPnj.add(new PNJ("Pierre", "Quelle terrible nouvelle. Je ne portais pas tant d'affection pour M.Duchêne, mais c'était un très bon ami d'Agathe.", true));
        //Pour Pierre il faut que lorsqu'on le questionne sur son bouton de chemise, son témoignage change et qu'il devienne hésitant

        lesPnj.add(new PNJ("Père Kent", "M'sieur, depuis ce midi je suis dans le jardin, regardez mon accoutrement, il est plein de boue! Je suis monté chercher des affaires dans la salle de jeu et c'est là  que j'ai découvert le corps sans vie.", true));
        lesPnj.add(new PNJ("Agathe", "OH MON DIEU! Qui aurait pu en vouloir à ce pauvre M.Duchêne, il était si gentil, beau, intelligent.. euh.. Bref dépêchez-vous de trouver le meurtrier!", false));
    }

    /**
     * permet d'afficher la zone dans laquelle se trouve le joueur
     */
    private void afficherLocalisation() {
            gui.afficher( zoneCourante.descriptionLongue());
            gui.afficher();
    }

    /**
     * message affiché lors du lancement du jeu
     */
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

    /**
     *
     * @param commandeLue
     */
    public void traiterCommande(String commandeLue) {
    	gui.afficher( "> "+ commandeLue + "\n");
        if(commandeLue.toUpperCase().matches("OUI [A-Z]* [A-Z]*"))
        {
            String[] parts = commandeLue.toUpperCase().split(" ");
            String meurtrier = parts[2];
            String arme = parts[1];
            resoudreEnquete(meurtrier, arme);
        }
        else {
            switch (commandeLue.toUpperCase()) {
                case "?":
                case "AIDE":
                    afficherAide();
                    break;
                case "N":
                case "NORD":
                    allerEn("NORD");
                    break;
                case "S":
                case "SUD":
                    allerEn("SUD");
                    break;
                case "E":
                case "EST":
                    allerEn("EST");
                    break;
                case "O":
                case "OUEST":
                    allerEn("OUEST");
                    break;
                case "Q":
                case "QUITTER":
                    terminer();
                    break;
                case "PARLER":
                case "P":
                    parler();
                    break;
                case "RECHERCHER":
                case "R":
                    rechercher();
                    break;
                case "SAC":
                    SacADos();
                    break;
                default:
                    gui.afficher("Commande inconnue");
                    break;
            }
        }
    }

    /**
     * affiche toutes les commandes possible
     */
    private void afficherAide() {
        gui.afficher("Etes-vous perdu ?");
        gui.afficher();
        gui.afficher("Les commandes autorisÃ©es sont :");
        gui.afficher();
        gui.afficher(Commande.toutesLesDescriptions().toString());
        gui.afficher();
    }

    /**
     * permet de changer l'emplacement du joueur, si cela est possible
     * @param direction correspond à la direction que le joueur veut prendre
     */
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

    /**
     * permet de savoir si le joueur à récupérer tous les indices, retourne vrai si oui
     * @return true or false
     */
    private boolean verifierIndice()
    {
        return joueur.getNbIndice() == nombreIndice;
    }

    /**
     *
     * @param lireNom
     * @param lireArme
     */
    public void resoudreEnquete(String lireNom, String lireArme)
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
                    gui.afficher();
                    terminer();
                    trouve = true;
                }
                else
                {
                    gui.afficher("Je doute que ce soit vraiment le tueur ou l'arme du crime !");
                    gui.afficher();
                    nbChance ++;
                }
            }
            if(!trouve)
            {
                gui.afficher("Vous n'avez pas réussi à résoudre l'enquête, malgré vos trois chances... Dommage");
                gui.afficher();
                terminer();
            }
        }
        else
        {
            gui.afficher("Vous n'avez pas récupérer tous les indices, vous ne pouvez donc pas encore résoudre l'enquête.");
            gui.afficher();
        }
    }

    /**
     * vérifie s'il y a une PNJ dans la pièce
     * si oui, le joueur récupère sont témoignage
     */
    private void parler()
    {
        if(zoneCourante.PNJ())
        {
            Indices i = new Indices(zoneCourante.getDescriptionPNJ(), "Témoignage", zoneCourante);
            gui.afficher(zoneCourante.getPNJ().toString() + " : " + zoneCourante.getDescriptionPNJ());
            joueur.ajouterIndice(i);
            if(zoneCourante.getPNJ().getNom() == "Indigo")
            {
                String nomDesPnj = "";
                for(PNJ unPnj : lesPnj) { nomDesPnj += unPnj.toString() + ", ";}
                gui.afficher("\n" + zoneCourante.getPNJ().toString() + " : Pour rappels les personnes presente dans ce manoir sont : "+ nomDesPnj);
                //Afficher les indices que le joueur a déjà trouvé
                //gui.afficher("\n Et voici vos indices trouvés : ");
                gui.afficher("\n" + zoneCourante.getPNJ().toString() + " : Voulez-vous m'indiquer qui est le meurtrier ainsi que l'arme du crime? OUI [arme] [Nom du personnage suspecté] / NON");
            }
        }
        else gui.afficher("Il n'y a personne dans la pièce.");
    }

    /**
     * permet de chercher des indices dans la pièce
     * s'il y a un indice, le joueur le récupère
     */
     private void rechercher()
    {
        if(zoneCourante.indice())
        {
            joueur.ajouterIndice(zoneCourante.getIndice());
            gui.afficher("Vous venez de récupérer un indice : " + zoneCourante.getIndice().getDescription());

            if(zoneCourante.getIndice().getNom() == "Observation du corps") {
                zoneCourante.ajouteIndice(new Indices("Pierre a lancé une boule de billard sur la fenêtre, cette dernière s'est brisée", "Bouts de verre", zoneCourante));
                lesPnj.get(2).setTemoignage("Mr Duchêne a été tué par une arme tranchante!");
            }
            else if(zoneCourante.getIndice().getNom() == "Bouts de verre")
            {
                zoneCourante.ajouteIndice(new Indices("Vous avez trouvé un bouton de chemise sous la table de billard. " +
                        "Ce bouton ressemble comme deux gouttes d'eau à celui de Pierre. Ce dernier avait un bouton manquant sur sa chemise", "Bouton de chemise", zoneCourante));
                lesPnj.get(2).setTemoignage("Il jouait avec Pierre, ceci est bizarre ..");
            }
            else if(zoneCourante.getIndice().getNom() == "Arme du crime")
                lesPnj.get(1).setTemoignage("Une arme ??? Le coupable doit être d'Agathe !");

            else if(zoneCourante.getIndice().getNom() == "Lettre d'amour")
            {
                lesPnj.get(3).setTemoignage("Je.... je ne comprends pas cette lettre. Certes il n'etait pas tellement mon ami...  ");
                gui.afficher("Vous remarquez qu'il manque quelque chose sur sa chemise...");
            }
            else if(zoneCourante.getIndice().getNom() == "Alliance")
                gui.afficher("Mme Duchêne est suspecte");
            else zoneCourante.indiceRecupere();
        }
        else gui.afficher("Il n'y a pas d'indice dans la pièce");
        gui.afficher();
    }

    /**
     * permet d'afficher tous les indices que le joueur a ramassé
     */
    public void SacADos()
    {
    	String sac = "";
    	if(joueur.getNbIndice() > 0)
    	{
    		for(Indices i : joueur.getIndice())
    		{
    			sac += i.getNom() + " : " + i.getDescription() + "\n";
    		}
    	}
    	else sac= "Il n'y a pas d'indice dans le sac à dos";

        gui.afficher(sac);
        gui.afficher();
    }

     /**
      * Ferme le jeu
      */
    private void terminer() {
    	gui.afficher( "Au revoir...");
    	gui.enable( false);
    }
}
