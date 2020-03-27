package jeu;
import java.util.HashMap;

public class Zone 
{
    private String description;
    private String nomImage;
    private HashMap<String,Zone> sorties;
    private PNJ personnagePNJ;
    private Indices indice;

    /**
     * constructeur
     * @param description
     * @param image
     */
    public Zone(String description, String image) {
        this.description = description;
        nomImage = image;
        sorties = new HashMap<>();
        personnagePNJ = null;
    }

    /**
     * permet d'ajouter un PNJ à la zone
     * @param unPnj
     */
    public void ajouterPNJSurMap(PNJ unPnj) { this.personnagePNJ = unPnj; }

    /**
     * retourne le PNJ
     * @return personnagePNJ
     */
    public PNJ getPNJ() { return this.personnagePNJ; }

    /**
     * ajoute une sortie à la salle
     * @param sortie : correspond à la sortie
     * @param zoneVoisine : correspond à la salle disponible du côté de la sortie
     */
    public void ajouteSortie(Sortie sortie, Zone zoneVoisine) {
        sorties.put(sortie.name(), zoneVoisine);
    }

    /**
     * retourne le lien de l'image
     * @return nomImage
     */
    public String nomImage() {
        return nomImage;
    }

    /**
     * retoune la description de la salle
     * @return description
     */
    public String toString() {
        return description;
    }

    /**
     * retourne une description et les sorties disponibles
     * @return description et les sorties
     */
    public String descriptionLongue()  {
        return "Vous êtes dans " + description + "\nSorties : " + sorties();
    }

    /**
     * retournes les sorties disponibles
     * @return
     */
    private String sorties() {
        return sorties.keySet().toString();
    }

    /**
     * retourne les sorties dans la direction
     * @param direction
     * @return
     */
    public Zone obtientSortie(String direction) {
    	return sorties.get(direction);
    }

    /**
     * retorune la description des PNJ de la zone
     * @return
     */
    public String getDescriptionPNJ()
    {
            return this.personnagePNJ.getTemoignage();
    }

    /**
     * retourne s'il y a un PNJ dans la zone
     * @return
     */
    public boolean PNJ()
    {
        return personnagePNJ != null;
    }

    /**
     * retourne s'il y a un indice dans la zone
     * @return
     */
    public boolean indice()
    {
        return indice != null;
    }

    /**
     * retourne l'indice de la zone
     * @return
     */
    public Indices getIndice()
    {
        return this.indice;
    }

    /**
     * permet d'ajouter un indice dans la zone
     * @param i : indice à ajouter
     */
    public void ajouteIndice(Indices i)
    {
        this.indice = i;
    }

    /**
     * permet de supprimer l'indice de la zone lorsque le joueur l'a récupéré
     */
    public void indiceRecupere()
    {
        this.indice = null;
    }
}

