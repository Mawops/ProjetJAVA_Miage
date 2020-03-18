package jeu;
import java.util.HashMap;

public class Zone 
{
    private String description;
    private String nomImage;
    private HashMap<String,Zone> sorties;
    private PNJ personnagePNJ;
    private Indices indice;

    public Zone(String description, String image) {
        this.description = description;
        nomImage = image;
        sorties = new HashMap<>();
        personnagePNJ = null;
    }

    public Zone(String description, String image, PNJ pPersonnagePNJ, Indices pIndice) {
        this.description = description;
        nomImage = image;
        sorties = new HashMap<>();
        personnagePNJ = pPersonnagePNJ;
        indice = pIndice;
    }

    public void ajouteSortie(Sortie sortie, Zone zoneVoisine) {
        sorties.put(sortie.name(), zoneVoisine);
    }

    public String nomImage() {
        return nomImage;
    }
     
    public String toString() {
        return description;
    }

    public String descriptionLongue()  {
        return "Vous êtes dans " + description + "\nSorties : " + sorties();
    }

    private String sorties() {
        return sorties.keySet().toString();
    }

    public Zone obtientSortie(String direction) {
    	return sorties.get(direction);
    }

    public String getDescriptionPNJ()
    {
        return this.personnagePNJ.getTemoignage();
    }

    public boolean PNJ()
    {
        if(personnagePNJ != null)
            return true;
        else return false;
    }

    public boolean indice()
    {
        if(indice != null)
            return true;
        else return false;
    }

    public Indices getIndice()
    {
        return this.indice;
    }
}

