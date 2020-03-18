package jeu;

public class PNJ extends Personnage{

    private String temoignage;

    public PNJ( String pNom, String pTemoignage)
    {
        super(pNom);
        this.temoignage = pTemoignage;
    }

    public String getTemoignage()
    {
        return this.temoignage;
    }
}
