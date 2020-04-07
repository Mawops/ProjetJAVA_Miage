package jeu;

public class Indices {

    //Initilisations des variables
    private String description;
    private Zone localisation;
    private String nom;
    private static int incrementTemoignage = 1;
    private static int increment = 0;

    /**
     *Constructeur
     * @param pDescription
     * @param pNom
     * @param pLocalisation
     */
    public Indices(String pDescription, String pNom, Zone pLocalisation)
    {
        increment ++;
        this.description = pDescription;
        if(pNom == "Témoignage")
        {
            this.nom = pNom + increment;
            incrementTemoignage ++;
        }
        else
        {
            this.nom = pNom;
        }
        this.localisation = pLocalisation;
    }

    /**
     * retourne la localisation de l'indice
     * @return localisation
     */
    public Zone getLocalisation()
    {
        return this.localisation;
    }

    /**
     * retourne la description de l'indice
     * @return description
     */
    public String getDescription()
    {
        return this.description;
    }

    /**
     * retourne le nom de l'indice
     * @return nom
     */
    public String getNom()
    {
        return this.nom;
    }

    public static void setIncrement(int n) { increment+=n ;}

    public static int getIncrement() {return increment;}

}
