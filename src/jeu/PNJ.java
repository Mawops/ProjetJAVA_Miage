package jeu;

public class PNJ extends Personnage{

    private String temoignage;
    private boolean sexe; //Homme = true, Femme = false
    private String emplacement;

    /**
     * constructeur
     * @param pNom
     * @param pTemoignage
     * @param unSexe
     */
    public PNJ( String pNom, String pTemoignage, boolean unSexe)
    {
        super(pNom);
        this.temoignage = pTemoignage;
        this.sexe = unSexe;
    }

    /**
     * retourne l'emplacement du PNJ
     * @return
     */
    public String getEmplacement() {return this.emplacement;}

    /**
     * Change l'emplacement d'un PNJ
     * @param unEmplacement
     */
    public void setEmplacement(String unEmplacement)
    {
        this.emplacement = unEmplacement;
    }

    /**
     * retourne le témoignage du PNJ
     * @return temoignage
     */
    public String getTemoignage()
    {
        return this.temoignage;
    }

    /**
     * Change le témoignage du PNJ
     * @param unAutreTemoignage
     */
    public void setTemoignage(String unAutreTemoignage)
    {
        this.temoignage = unAutreTemoignage;
    }

    /**
     * retourne le nom du PNJ avec sa civilité
     * @return
     */
    @Override
    public String toString() {
        if(this.sexe == true)
        {
            return "M. " + this.getNom();
        }
        else
        {
            return "Mme. " + this.getNom();
        }
    }

}

