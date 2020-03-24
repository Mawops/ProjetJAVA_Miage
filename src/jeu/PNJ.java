package jeu;

public class PNJ extends Personnage{

    private String temoignage;
    private boolean sexe; //Homme = true, Femme = false
    private String emplacement;

    public PNJ( String pNom, String pTemoignage, boolean unSexe)
    {
        super(pNom);
        this.temoignage = pTemoignage;
        this.sexe = unSexe;
    }

    public String getEmplacement() {return this.emplacement;}
    public void setEmplacement(String unEmplacement)
    {
        this.emplacement = unEmplacement;
    }
    public String getTemoignage()
    {
        return this.temoignage;
    }
    public void setTemoignage(String unAutreTemoignage)
    {
        this.temoignage = unAutreTemoignage;
    }

    @Override
    public String toString() {
        if(this.sexe == true)
        {
            return "M." + this.getNom();
        }
        else
        {
            return "Mme." + this.getNom();
        }
    }
<<<<<<< Updated upstream

}



=======
}
>>>>>>> Stashed changes
