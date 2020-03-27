package tests;

import jeu.Jeu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JeuTest {

    Jeu jeu1;

    @BeforeEach
    void setUp() {
        jeu1 = new Jeu();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void setGUI() {
    }

    @Test
    void traiterCommande() {
        String cmd1 = "Oui";
        String cmd2 = "OUI COUTEAU INDIGO";
        String cmd3 = "OUI COUTEAU INDIGO OK OK";
        assertFalse(cmd1.matches("OUI [A-Z]* [A-Z]*"));
        assertTrue(cmd2.matches("OUI [A-Z]* [A-Z]*"));
        assertFalse(cmd1.matches("OUI [A-Z]* [A-Z]*"));
    }

    @Test
    void resoudreEnquete() {

    }

    @Test
    void sacADos() {
        //assertEquals("Il n'y a pas d'indice dans le sac à dos", SacADos());
    }
}