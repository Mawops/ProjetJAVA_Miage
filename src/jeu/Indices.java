package jeu;

public class Indices {

    private String description;
    private Zone localisation;
    private String nom;
    private static int increment = 1;

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

    public Zone getLocalisation()
    {
        return this.localisation;
    }

    public String getDescription()
    {
        return this.description;
    }

    public String getNom()
    {
        return this.nom;
    }
}
