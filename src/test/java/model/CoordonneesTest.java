package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.smartmapper.core.domain.model.Coordonnees;
import com.smartmapper.core.domain.model.PointInteret;

import org.junit.Before;
import org.junit.Test;

public class CoordonneesTest {
    static Coordonnees instance = new Coordonnees();
    static PointInteret pointInteret = new PointInteret();

    @Before
    public void setup() {
        instance.setLatitude(10.0);
        instance.setLongitude(10.0);
        instance.setId(1L);
        instance.setPoint(pointInteret);
    }

    @Test
    public void testSetId() {
        assertEquals(Long.valueOf(1L), instance.getId());
    }

    @Test
    public void testSetLatitude() {
        assertEquals(10.0, instance.getLatitude());
    }

    @Test
    public void testSetLongitude() {
        assertEquals(10.0, instance.getLongitude());
    }

    @Test
    public void testSetPoint() {
        assertEquals(pointInteret, instance.getPoint());
    }

    @Test
    public void testGetId() {
        assertEquals(true, Long.valueOf(1L).equals(instance.getId()));
    }

    @Test
    public void testGetLatitude() {
        assertEquals(true, Double.valueOf(10.0).equals(instance.getLatitude()));
    }
    @Test
    public void testGetLongitude() {
        assertEquals(true, Double.valueOf(10.0).equals(instance.getLatitude()));
    }

    @Test
    public void testGetPoint() {
        assertEquals(true, pointInteret.equals(instance.getPoint()));
    }
}
