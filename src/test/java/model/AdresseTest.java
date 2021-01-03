package model;

import static org.junit.Assert.assertEquals;
import com.smartmapper.core.domain.model.Adresse;
import com.smartmapper.core.domain.model.PointInteret;

import org.junit.Before;
import org.junit.Test;

public class AdresseTest {
    static Adresse instance = new Adresse();
    static PointInteret pointInteret = new PointInteret();

    @Before
    public void setup() {
        instance.setCodePostal("test");
        instance.setId(1L);
        instance.setLines("test");
        instance.setName("test");
        instance.setPays("test");
        instance.setPoint(pointInteret);
        instance.setTelephone("test");
        instance.setVille("test");
    }
   
    @Test
    public void testSetCedex() {
        assertEquals("test", instance.getCedex());
    }

    @Test
    public void testSetCodePostal() {
        assertEquals("test", instance.getCodePostal());
    }

    @Test
    public void testSetId() {
        assertEquals(Long.valueOf(1L), instance.getId());
    }

    @Test
    public void testSetLines() {
        assertEquals("test", instance.getLines());
    }

    @Test
    public void testSetName() {
        assertEquals("test", instance.getName());
    }

    @Test
    public void testSetPays() {
        assertEquals("test", instance.getPays());
    }

    @Test
    public void testSetPoint() {
        assertEquals(pointInteret, instance.getPoint());
    }

    @Test
    public void testSetTelephone() {
        assertEquals("test", instance.getTelephone());
    }

    @Test
    public void testSetVille() {
        assertEquals("test", instance.getVille());
    }

    @Test
    public void testGetCedex() {
        instance.setCedex("test");
        assertEquals(true, "test".equals(instance.getCedex()));
    }

    @Test
    public void testGetCodePostal() {
        assertEquals(true, "test".equals(instance.getCodePostal()));
    }

    @Test
    public void testGetId() {
        assertEquals(true, Long.valueOf(1L).equals(instance.getId()));
    }

    @Test
    public void testGetLines() {
        assertEquals(true, "test".equals(instance.getLines()));
    }

    @Test
    public void testGetName() {
        assertEquals(true, "test".equals(instance.getName()));
    }

    @Test
    public void testGetPays() {
        assertEquals(true, "test".equals(instance.getPays()));
    }

    @Test
    public void testGetPoint() {
        assertEquals(true, pointInteret.equals(instance.getPoint()));
    }

    @Test
    public void testGetTelephone() {
        assertEquals(true, "test".equals(instance.getTelephone()));
    }

    @Test
    public void testGetVille() {
        assertEquals(true, "test".equals(instance.getVille()));
    }
}
