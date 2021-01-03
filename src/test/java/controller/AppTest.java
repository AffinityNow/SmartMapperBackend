package controller;

import com.smartmapper.core.domain.model.Categorie;
import com.smartmapper.core.domain.model.Coordonnees;
import com.smartmapper.core.domain.model.PointInteret;
import com.smartmapper.core.infra.repository.PointInteretRepository;
import com.smartmapper.core.infra.service.serviceImpl.PointInteretServiceImpl;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class AppTest {

    @Test
    public void should_get_distance_between_two_points() {
        // Given:


        PointInteretServiceImpl test = new PointInteretServiceImpl(null);
        //given
        double lat1 = 48.9504898;
        double lg1 = 2.1638332;

        double lat2 = 48.822469;
        double lg2 = 2.245169;
        double expected = 0.15167345711850837877966928702302;
        //when
        double actual = test.distance(lat1, lg1, lat2, lg2);
        //then
        assertEquals(expected, actual, 1e-9);
    }


    @Test
    public void should_sort_points() {
        // Given:
        PointInteret p1 = Mockito.mock(PointInteret.class);
        PointInteret p2 = Mockito.mock(PointInteret.class);
        PointInteret p3 = Mockito.mock(PointInteret.class);

        Mockito.when(p1.getCoordonnes()).thenReturn(new Coordonnees().setLatitude(48.9504898).setLongitude(2.1638332));
        Mockito.when(p1.getCategories()).thenReturn(Set.of(new Categorie(null, "sport")));

        Mockito.when(p2.getCoordonnes()).thenReturn(new Coordonnees().setLatitude(148.822469).setLongitude(2.245169));
        Mockito.when(p2.getCategories()).thenReturn(Set.of(new Categorie(null, "sport")));

        Mockito.when(p3.getCoordonnes()).thenReturn(new Coordonnees().setLatitude(49.822469).setLongitude(-2.245169));
        Mockito.when(p3.getCategories()).thenReturn(Set.of(new Categorie(null, "sport")));

        PointInteretRepository repository = Mockito.mock(PointInteretRepository.class);
        Mockito.when(repository.findAll()).thenReturn(List.of(p1, p2, p3));

        PointInteretServiceImpl test = new PointInteretServiceImpl(repository);

        // When:
        List<PointInteret> actual = test.getByCategoryandByPosition("sport", 48.9504898, 2.1638332);

        // Then:
        List<PointInteret> expected = List.of(p1, p3, p2);

        assertEquals(expected, actual);

    }





}
