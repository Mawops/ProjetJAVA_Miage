package jeu;

import java.util.ArrayList;

public class Joueur extends Personnage {

    private ArrayList<Indices> listeIndice;

    /**
     *
     * @param pNom
     */
    public Joueur(String pNom)
    {
        super(pNom);
        listeIndice = new ArrayList<Indices>();
    }

    /**
     *
     * @param nom
     * @return
     */
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

    /**
     *
     * @param i
     */
    public void ajouterIndice(Indices i)
    {
        listeIndice.add(i);
    }

    /**
     *
     * @return
     */
    public int getNbIndice()
    {
        return listeIndice.size();
    }
}
