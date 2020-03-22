package jeu;

public abstract class Personnage {

    private String nom;

    public Personnage(String pNom)
    {
        this.nom = pNom;
    }

    public String getNom() { return this.nom; }
}
