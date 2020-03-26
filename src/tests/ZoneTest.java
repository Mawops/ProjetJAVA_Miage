package tests;

import jeu.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZoneTest {

    Zone z1;
    Zone z2;
    Zone z3;
    PNJ pnj1;
    Sortie s1;
    Indices i1;

    @BeforeEach
    void setUp() {
        z1 = new Zone("", "");
        z2 = new Zone("salle de bain", "salleDeBain.jpg");
        z3 = new Zone("salle de jeu", "salleDeJeu.jpg");
        pnj1 = new PNJ("test", "je ne sais pas ce qui se passe", false);
        s1 = Sortie.SUD;
        i1 = new Indices("un superbe indice", "indice", z2);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void ajouterPNJSurMap() {
        z2.ajouterPNJSurMap(pnj1);
    }

    @Test
    void getPNJ() {
        z2.ajouterPNJSurMap(pnj1);
        assertEquals(pnj1, z2.getPNJ());
        assertEquals(null, z3.getPNJ());
    }

    @Test
    void ajouteSortie() {
        z2.ajouteSortie(s1, z3);
        //assertEquals(Sortie.SUD, z2.);
    }

    @Test
    void nomImage() {
        assertEquals("", z1.nomImage());
        assertEquals("salleDeBain.jpg", z2.nomImage());
        assertEquals("salleDeJeu.jpg", z3.nomImage());
    }

    @Test
    void testToString() {
        assertEquals("", z1.toString());
        assertEquals("salle de bain", z2.toString());
        assertEquals("salle de jeu", z3.toString());
    }

    @Test
    void descriptionLongue() {
        z2.ajouteSortie(s1, z3);
        assertEquals("Vous êtes dans \nSorties : []", z1.descriptionLongue());
        assertEquals("Vous êtes dans salle de bain\nSorties : [SUD]", z2.descriptionLongue());
        assertEquals("Vous êtes dans salle de jeu\nSorties : []", z3.descriptionLongue());
    }

    @Test
    void obtientSortie() {
        z2.ajouteSortie(s1, z3);
        assertEquals(z3, z2.obtientSortie("SUD"));
    }

    @Test
    void getDescriptionPNJ() {
        z3.ajouterPNJSurMap(pnj1);
        assertNull(z1.getDescriptionPNJ());
        assertNull(z2.getDescriptionPNJ());
        assertEquals("je ne sais pas ce qui se passe", z3.getDescriptionPNJ());
    }

    @Test
    void PNJ() {
        z3.ajouterPNJSurMap(pnj1);
        assertTrue(z3.PNJ());
        assertFalse(z2.PNJ());
        assertFalse(z1.PNJ());
    }

    @Test
    void indice() {
        assertFalse(z1.indice());
        assertFalse(z3.indice());
        assertFalse(z2.indice());
        z2.ajouteIndice(new Indices("un superbe indice", "indice", z2));
        assertTrue(z2.indice());
    }

    @Test
    void getIndice() {
        z2.ajouteIndice(i1);
        assertFalse(new Indices("un superbe indice", "indice", z2) == z2.getIndice());
        assertEquals(i1, z2.getIndice());
    }

    @Test
    void ajouteIndice() {
        assertTrue(z2.getIndice() == null);
        z2.ajouteIndice(i1);
        assertTrue(z2.getIndice() == i1);
    }

    @Test
    void indiceRecupere() {
        z2.ajouteIndice(i1);
        assertTrue(z2.getIndice() == i1);
        z2.indiceRecupere();
        assertTrue(z2.getIndice() == null);
    }
}