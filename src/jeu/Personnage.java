package jeu;

public abstract class Personnage {

    private String nom;

    /**
     * Constructeur
     *@param nNom : nom du personnage
     */
    public Personnage(String pNom)
    {
        this.nom = pNom;
    }

    /**
     * retourne le nom du personnage
     * @return nom
     */
    public String getNom() { return this.nom; }
}
