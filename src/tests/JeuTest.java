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
        String cmd2 = "ACCUSER COUTEAU INDIGO";
        String cmd3 = "ACCUSER COUTEAU INDIGO OK OK";
        assertFalse(cmd1.matches("ACCUSER [A-Z]* [A-Z]*"));
        assertTrue(cmd2.matches("ACCUSER [A-Z]* [A-Z]*"));
        assertFalse(cmd1.matches("ACCUSER [A-Z]* [A-Z]*"));
    }

    @Test
    void resoudreEnquete() {

    }

    @Test
    void sacADos() {

    }
}