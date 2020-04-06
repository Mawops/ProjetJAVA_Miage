package jeu;

import java.util.ArrayList;

public class Joueur extends Personnage {

    private ArrayList<Indice> listeIndice;

    /**
     *Constructeur
     *Initialise la liste des indices
     * @param pNom
     */
    public Joueur(String pNom)
    {
        super(pNom);
        listeIndice = new ArrayList<Indice>();
    }

    /**
     * recherche un indice dans la liste
     * @param nom : nom de l'indice
     * @return true or false
     */
    public boolean trouverIndice(String nom)
    {
        boolean trouve = false;
        for(Indice i : listeIndice)
        {
            if(i.getNom() == nom)
            {
                trouve = true;
            }
        }
        return trouve;
    }


    /**
     * recherche une description dans la liste
     * @param nom : nom de la description
     * @return true or false
     */
    public boolean trouveDescription(String nom)
    {
        boolean trouve = false;
        for(Indice i : listeIndice)
        {
            if(i.getDescription() == nom)
            {
                trouve = true;
            }
        }
        return trouve;
    }

    /**
     * ajoute un nouvel indice dans la liste
     * @param i : indice à ajouter
     */
    public void ajouterIndice(Indice i)
    {
        listeIndice.add(i);
    }

    /**
     *retourne le nombre d'indice dans la liste
     * @return
     */
    public int getNbIndice()
    {
        return listeIndice.size();
    }

    /**
     * retourne la liste d'indice
     * @return
     */
    public ArrayList<Indice> getIndice()
    {
        return listeIndice;
    }
}
