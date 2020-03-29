package tests;

import jeu.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JoueurTest {

    Joueur j1;
    Joueur j2;
    Zone z1;
    ArrayList<Indices> i2;

    @BeforeEach
    void setUp() {
        j1 = new Joueur("Camarade");
        j2 = new Joueur("");
        z1 = new Zone("jeu", "jeu.jpg");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void trouverIndice() {
        assertFalse(j1.trouverIndice("test"));
        j2.ajouterIndice(new Indices("je suis un indice", "indice", z1));
        assertTrue(j2.trouverIndice("indice"));
    }

    @Test
    void ajouterIndice() {
        j1.ajouterIndice(new Indices("je suis un indice", "indice", z1));
        assertTrue(j1.trouverIndice("indice"));
    }

    @Test
    void getNbIndice() {
        assertEquals(0, j2.getNbIndice());
        j1.ajouterIndice(new Indices("je suis un indice", "indice", z1));
        assertEquals(1, j1.getNbIndice());
    }

    @Test
    void getIndice() {
        assertEquals(i2 = new ArrayList<>(), j1.getIndice());
    }
}