package tests
import jeu.Indices;
import jeu.Zone;

import groovy.test.GroovyAssert;

class IndicesTest extends GroovyTestCase {

    void setUp() {
        super.setUp()
        Zone z1 = new Zone("salle à manger", "SalleAManger.jpg");
        Indices i1 = new Indices ();
        Indices i2 = new Indices("Je fais une description d'un témoignage", "Témoignage", z1)
    }

    void tearDown() {
    }

    void testGetLocalisation() {
        assertEquals(z1, i2.getLocalisation());
    }

    void testGetDescription() {
        assertToString(i2.getDescription(), "Je fais une description d'un témoignage");
    }

    void testGetNom() {
    }
}
