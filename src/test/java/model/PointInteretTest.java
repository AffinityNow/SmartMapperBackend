package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import com.smartmapper.core.domain.model.Adresse;
import com.smartmapper.core.domain.model.Categorie;
import com.smartmapper.core.domain.model.Coordonnees;
import com.smartmapper.core.domain.model.PointInteret;

import org.junit.Before;
import org.junit.Test;

public class PointInteretTest {
    static PointInteret instance = new PointInteret();
    static Adresse adresse = new Adresse();
    static Coordonnees coordonnees = new Coordonnees();
    static Categorie c1 = new Categorie();
    static Set<Categorie> categories = Set.of(c1);

    @Before
    public void setup() {
        instance.setAdresse(adresse);
        c1.setId(1L);        
        c1.setId(2L);        
        instance.setCategories(categories);
        instance.setCoordonnes(coordonnees);
        instance.setDescription("test");
        instance.setId(1L);
        instance.setName("test");
    }
   
    @Test
    public void testSetAdresse() {
        assertEquals(adresse, instance.getAdresse());
    }

    @Test
    public void testSetCatpgories() {
        assertEquals(categories, instance.getCategories());
    }

    @Test
    public void testSetCoordonnes() {
        assertEquals(coordonnees, instance.getCoordonnes());
    }

    @Test
    public void testSetDescription() {
        assertEquals("test", instance.getDescription());
    }

    @Test
    public void testSetName() {
        assertEquals("test", instance.getName());
    }

    @Test
    public void testSetId() {
        assertEquals(1L, instance.getId());
    }

    @Test
    public void testGetAdresse() {
        assertEquals(true, adresse.equals(instance.getAdresse()));
    }

    @Test
    public void testGetId() {
        assertEquals(true, Long.valueOf(1L).equals(instance.getId()));
    }

    @Test
    public void testGetName() {
        assertEquals(true, "test".equals(instance.getName()));
    }

    @Test
    public void testGetCoordonnees() {
        assertEquals(true, coordonnees.equals(instance.getCoordonnes()));
    }


    @Test
    public void testGetDescription() {
        assertEquals(true, "test".equals(instance.getDescription()));
    }
}
