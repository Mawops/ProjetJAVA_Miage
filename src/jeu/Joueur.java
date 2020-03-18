package jeu;

import java.util.ArrayList;

public class Joueur extends Personnage {

    private ArrayList<Indices> listeIndice;

    public Joueur(String pNom)
    {
        super(pNom);
        listeIndice = new ArrayList<Indices>();
    }

    public boolean trouverIndice(String nom)
    {
        boolean trouve = false;
        for(Indices i : listeIndice)
        {
            if(i.getNom() == nom)
            {
                trouve = true;
            }
        }
        return trouve;
    }

    public void ajouter(Indices i)
    {
        listeIndice.add(i);
    }
}
