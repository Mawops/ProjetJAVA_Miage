package jeu;

public class Indices {

    private String description;
    private Zone localisation;
    private String nom;
    private static int increment = 1;

    /**
     *Constructeur
     * @param pDescription
     * @param pNom
     * @param pLocalisation
     */
    public Indices(String pDescription, String pNom, Zone pLocalisation)
    {
        this.description = pDescription;
        if(pNom == "temoignage")
        {
            this.nom = pNom + increment;
            increment ++;
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

}
