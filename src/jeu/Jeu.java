package jeu;
import java.util.*;

public class Jeu {

    //Initialisations
    private GUI gui;
    private Zone zoneCourante;
    private Joueur joueur;
    private int nombreIndice = 6;
    private Zone [] lesZones;
    private ArrayList<PNJ> lesPnj;

    /**
     * Constructeur du jeu
     */
    public Jeu() {
        lesZones = new Zone[11];
        lesPnj = new ArrayList<PNJ>();

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
     *crÃ©ation du joueur
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
        lesZones[4].ajouterPNJSurMap(lesPnj.get(5));
        lesZones[8].ajouterPNJSurMap(lesPnj.get(4));
        //Pierre n'apparaît pas tant qu'on a pas trouvé la lettre d'Agathe
    }

    /**
     * crÃ©ation de la carte :
     * crÃ©ation des diffÃ©rentes zones
     * crÃ©ation des liens entre les zones
     */
    private void creerCarte() {

        //Zone [] zones = new Zone [11];
        lesZones[0] = new Zone("le hall", "hall.jpg");
        lesZones[1] = new Zone("la salle Ã  manger", "salleAManger.jpg");
        lesZones[2] = new Zone("la salle de jeux", "SalleDeJeu.jpg");
        lesZones[3] = new Zone("la cuisine", "cuisine.jpg" );
        lesZones[4] = new Zone("la chambre 1", "chambre1.jpg");
        lesZones[5] = new Zone("la chambre des DuchÃªne", "chambre2.jpg");
        lesZones[6] = new Zone("la bibliothÃ¨que", "bibliotheque.jpg");
        lesZones[7] = new Zone("la salle de bain", "salleDeBain.jpg");
        lesZones[8] = new Zone("la buanderie", "buanderie.jpg");
        lesZones[9] = new Zone("la cave", "caveSansPierre.jpg");
        lesZones[10] = new Zone("le couloir", "couloir.jpg");

        /*rez de chaussÃ©e */
        lesZones[0].ajouteSortie(Sortie.OUEST, lesZones[1]);
        lesZones[0].ajouteSortie(Sortie.NORD, lesZones[3]);
        lesZones[0].ajouteSortie(Sortie.EST, lesZones[2]);

        lesZones[1].ajouteSortie(Sortie.EST, lesZones[0]);
        lesZones[1].ajouteSortie(Sortie.SUD, lesZones[6]);

        lesZones[2].ajouteSortie(Sortie.OUEST, lesZones[0]);
        lesZones[3].ajouteSortie(Sortie.SUD, lesZones[0]);

        /*Premier Ã©tage */
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
        lesZones[6].ajouteIndice(new Indices("Lettre d'amour Ã©crite par Agathe pour un homme, autre que son mari Pierre", "Lettre d'amour", lesZones[6]));
        lesZones[5].ajouteIndice(new Indices("Alliance de Mr DuchÃªne", "Alliance", lesZones[5]));
        lesZones[3].ajouteIndice(new Indices("Couteau fraÃ®chement nettoyÃ© et dissimulÃ© dans le tiroir, parmis les fourchettes", "Arme du crime", lesZones[3]));
        lesZones[2].ajouteIndice(new Indices("Le corps Ã  trois plaies profondes dans le torse, " +
                "dont deux dans le ventre et une dans la poitrine. De plus l'alliance de Mr DuchÃªne est manquante", "Observation du corps", lesZones[2]));

    }

    /**
     * crÃ©ation de tous les PNJ pour le fonctionnement du jeu
     */
    private void creerPNJ()
    {
        lesPnj.add(new PNJ("DuchÃªne", "...", true));
        lesPnj.add(new PNJ("DuchÃªne", "Mon pauvre mari... Je.. Je suis anÃ©antie, nous venons Ã  peine de nous marier... Il Ã©tait proche d'Agathe ces temps-ci j'Ã©tais si heureuse que nos amis s'entendent bien... L'assassin est forcÃ©ment dans cette maison! TROUVEZ-LE VITE!", false));
        lesPnj.add(new PNJ("Indigo", "Le meurtrier n'est forcÃ©ment pas loin ! Il n'y a pas une minute Ã  perdre!", true));

        lesPnj.add(new PNJ("Pierre", "Quelle terrible nouvelle. Je ne portais pas tant d'affection pour M.DuchÃªne, mais c'Ã©tait un trÃ¨s bon ami d'Agathe.", true));
        //Pour Pierre il faut que lorsqu'on le questionne sur son bouton de chemise, son tÃ©moignage change et qu'il devienne hÃ©sitant

        lesPnj.add(new PNJ("PÃ¨re Kent", "M'sieur, depuis ce midi je suis dans le jardin, regardez mon accoutrement, il est plein de boue! Je suis montÃ© chercher des affaires dans la salle de jeu et c'est lÃ Â  que j'ai dÃ©couvert le corps sans vie.", true));
        lesPnj.add(new PNJ("Agathe", "OH MON DIEU! Qui aurait pu en vouloir Ã  ce pauvre M.DuchÃªne, il Ã©tait si gentil, beau, intelligent.. euh.. Bref dÃ©pÃªchez-vous de trouver le meurtrier!", false));
    }

    /**
     * permet d'afficher la zone dans laquelle se trouve le joueur
     */
    private void afficherLocalisation() {
        gui.afficher( zoneCourante.descriptionLongue());
        gui.afficher();
    }

    /**
     * message affichÃ© lors du lancement du jeu
     */
    private void afficherMessageDeBienvenue() {
        gui.afficher("Bienvenue " + joueur.getNom() + " !");
        gui.afficher();
        gui.afficher("Tapez '?' pour obtenir de l'aide.");
        gui.afficher();
        gui.afficher("Il y a eu un meurtre dans le manoir de Mr et Mme DuchÃªne, et tu vas m'aider Ã  le rÃ©soudre !");
        gui.afficher();
        gui.afficher("Allons rÃ©cupÃ©rer les clÃ© du manoir au concierge.");
        gui.afficher();
        gui.afficher("Ensuite aller Ã  la salle de jeu (Ã  l'est) pour examiner le corps du cadavre");
        gui.afficher();
        afficherLocalisation();
        gui.afficheImage(zoneCourante.nomImage());
    }

    /**
     *
     * @param commandeLue
     */
    public void traiterCommande(String commandeLue) throws Exception {
        gui.afficher( "> "+ commandeLue + "\n");
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
                if(commandeLue.toUpperCase().matches("ACCUSER [A-Z]* [A-Z]*") && zoneCourante == lesZones[0])
                {
                    String[] parts = commandeLue.toUpperCase().split(" ");
                    String meurtrier = parts[2];
                    String arme = parts[1];
                    resoudreEnquete(meurtrier, arme);
                }
                else { gui.afficher("Commande inconnue");}
                break;
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
     * @param direction correspond Ã  la direction que le joueur veut prendre
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
     * permet de savoir si le joueur Ã  rÃ©cupÃ©rer tous les indices, retourne vrai si oui
     * @return true or false
     */
    private boolean verifierIndice()
    {
        return joueur.getNbIndice() >= nombreIndice;
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
            if(nbChance <= 3 && !trouve)
            {
                if((lireNom.equals("PIERRE")) && (lireArme.equals("COUTEAU")))
                {
                    gui.afficher("Bravo vous avez rÃ©ussi Ã  rÃ©soudre l'enquÃªte !");
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
            if(nbChance >3 && !trouve)
            {
                gui.afficher("Vous n'avez pas rÃ©ussi Ã  rÃ©soudre l'enquÃªte, malgrÃ© vos trois chances... Dommage");
                gui.afficher();
                terminer();
            }
        }
        else
        {
            gui.afficher("Vous n'avez pas rÃ©cupÃ©rer tous les indices, vous ne pouvez donc pas encore rÃ©soudre l'enquÃªte.");
            gui.afficher();
        }
    }

    /**
     * vÃ©rifie s'il y a une PNJ dans la piÃ¨ce
     * si oui, le joueur rÃ©cupÃ¨re son tÃ©moignage
     */
    private void parler() throws Exception {
        if (zoneCourante.PNJ()) {
            Indices i = new Indices(zoneCourante.getDescriptionPNJ(), "TÃ©moignage", zoneCourante);
           // gui.afficher(zoneCourante.getPNJ().toString() + " : " + zoneCourante.getDescriptionPNJ());
           // if(joueur.trouveDescription(i.getDescription())) {
             //   joueur.ajouterIndice(i);
          //  } else {
            //    Indices.setIncrement(-1);


            if (zoneCourante.getPNJ().getNom() == "Indigo") {
                String nomDesPnj = "";
                for (PNJ unPnj : lesPnj) {
                    nomDesPnj += unPnj.toString() + ",\n";
                }
                gui.afficher("\n" + zoneCourante.getPNJ().toString() + " : Pour rappels les personnes prÃ©sente dans ce manoir sont : \n" + nomDesPnj);
                if (verifierIndice())
                    gui.afficher("\n" + zoneCourante.getPNJ().toString() + " : Voulez-vous m'indiquer qui est le meurtrier ainsi que l'arme du crime? ACCUSER [ARME] [NOM DU PERSONNAGE SUSPECTE] / NON");

                joueur.ajouterIndice(i);
                if (zoneCourante.getPNJ().getNom() == "Indigo") {
                    nomDesPnj = "";
                    for (PNJ unPnj : lesPnj) {
                        nomDesPnj += unPnj.toString() + ",\n";
                    }
                    gui.afficher("\n" + zoneCourante.getPNJ().toString() + " : Pour rappels les personnes présente dans ce manoir sont : \n" + nomDesPnj);
                    if (verifierIndice())
                        gui.afficher("\n" + zoneCourante.getPNJ().toString() + " : Voulez-vous m'indiquer qui est le meurtrier ainsi que l'arme du crime? ACCUSER [ARME] [NOM DU PERSONNAGE SUSPECTE] / NON");
                }
            } else gui.afficher("Il n'y a personne dans la piÃ¨ce.");
        }
    }

    /**
     * permet de chercher des indices dans la piÃ¨ce
     * s'il y a un indice, le joueur le rÃ©cupÃ¨re
     */
    private void rechercher()
    {
        if(zoneCourante.indice())
        {
            if(!joueur.trouverIndice(zoneCourante.getIndice().getNom()))
            {
                joueur.ajouterIndice(zoneCourante.getIndice());
                gui.afficher("Vous venez de récupérer un indice : " + zoneCourante.getIndice().getDescription());

                if (zoneCourante.getIndice().getNom() == "Observation du corps") {
                    zoneCourante.ajouteIndice(new Indices("Pierre a lancé une boule de billard sur la fenêtre,\ncette dernière s'est brisée", "Bouts de verre", zoneCourante));

                } else if (zoneCourante.getIndice().getNom() == "Bouts de verre") {
                    zoneCourante.ajouteIndice(new Indices("Vous avez trouvé un bouton de chemise sous la table de billard.\n" +
                            "Ce bouton ressemble comme deux gouttes d'eau Ã  celui de Pierre.\nCe dernier avait un bouton manquant sur sa chemise", "Bouton de chemise", zoneCourante));
                    lesPnj.get(2).setTemoignage("Il jouait avec Pierre, ceci est bizarre ..");
                } else if (zoneCourante.getIndice().getNom() == "Arme du crime")
                    lesPnj.get(1).setTemoignage("Une arme ??? Le coupable doit être d'Agathe !");

                else if (zoneCourante.getIndice().getNom() == "Lettre d'amour") {
                    lesPnj.get(3).setTemoignage("Je.... je ne comprends pas cette lettre.\nCertes il n'était pas vraiment mon ami...");
                    gui.afficher("Vous remarquez qu'il manque quelque chose sur sa chemise...");
                } else if (zoneCourante.getIndice().getNom() == "Alliance")
                    gui.afficher(" Mme Duchêne est suspecte");
                else if (zoneCourante.getIndice().getNom() == "Bouton de chemise") {
                    lesZones[9].ajouterPNJSurMap(lesPnj.get(3));
                    lesZones[9].setNomImage("caveAvecPierre.jpg");
                    zoneCourante.indiceRecupere();
                } else zoneCourante.indiceRecupere();
            }
            else gui.afficher("Vous avez déjà  récupéré les indices de la pièce");
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
        else sac= "Il n'y a pas d'indice dans le sac Ã  dos";

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
