package tests;

import jeu.Zone;
import jeu.Indices;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndicesTest {

    Zone z1;
    Indices i1;
    Indices i2;
    Indices i3;

    @BeforeEach
    void setUp() {
        z1 = new Zone("salle à manger", "SalleAManger.jpg");
        i1 = new Indices("","", null);
        i2 = new Indices("je décris un témoignage", "temoignage", z1);
        i3 = new Indices("je décris un témoignage", "Témoignage", z1);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getLocalisation() {
        assertTrue(z1 == i2.getLocalisation());
        assertTrue(i1.getLocalisation() == null);
    }

    @Test
    void getDescription() {
        assertEquals("je décris un témoignage", i2.getDescription());
        assertEquals("", i1.getDescription());
    }

    @Test
    void getNom() {
        assertFalse("Témoignage1" == i2.getNom());
        assertEquals("Témoignage1", i3.getNom());
        assertEquals("", i1.getNom());
    }
}