package tests;

import jeu.PNJ;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PNJTest {

    PNJ pnj1;
    PNJ pnj2;

    @BeforeEach
    void setUp() {
        pnj1 = new PNJ("pnj1", "je ne sais rien du tout, aller voir pnj2", false);
        pnj2 = new PNJ("pnj2", "je ne sais rien du tout, aller voir pnj1", true);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getEmplacement() {

    }

    @Test
    void setEmplacement() {
    }

    @Test
    void getTemoignage() {
        assertEquals("je ne sais rien du tout, aller voir pnj2", pnj1.getTemoignage());
        assertEquals("je ne sais rien du tout, aller voir pnj1", pnj2.getTemoignage());
    }

    @Test
    void setTemoignage() {
        pnj1.setTemoignage("je sais que pnj2 n'était pas dans sa chambre ce soir là");
        assertFalse("je ne sais rien du tout, aller voir pnj2" == pnj1.getTemoignage());
        assertEquals("je sais que pnj2 n'était pas dans sa chambre ce soir là", pnj1.getTemoignage());
    }

    @Test
    void testToString() {
        assertEquals("Mme. pnj1", pnj1.toString());
        assertEquals("M. pnj2", pnj2.toString());
    }
}