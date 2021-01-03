package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.smartmapper.core.domain.model.Categorie;
import com.smartmapper.core.domain.model.PointInteret;

import org.junit.Before;
import org.junit.Test;

public class CategorieTest {
    static Categorie instance = new Categorie();
    static PointInteret pointInteret = new PointInteret();

    @Before
    public void setup() {
        instance.setName("test");
        instance.setId(1L);
        instance.setPointInteret(pointInteret);
    }

    @Test
    public void testSetId() {
        assertEquals(Long.valueOf(1L), instance.getId());
    }

    @Test
    public void testSetName() {
        assertEquals("test", instance.getName());
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
    public void testGetPoint() {
        assertEquals(true, pointInteret.equals(instance.getPoint()));
    }
}
