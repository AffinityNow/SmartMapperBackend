package controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.smartmapper.core.domain.model.Categorie;
import com.smartmapper.core.domain.model.PointInteret;
import com.smartmapper.core.infra.controller.PointInteretController;
import com.smartmapper.core.infra.service.PointInteretService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PointInteretControllerTest {

    @InjectMocks
    private PointInteretController pInteretController;

    @Mock
    private PointInteretService pService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllPointInterets() {
        final PointInteret p1 = new PointInteret();
        final PointInteret p2 = new PointInteret();
        p1.setId(1L);
        p2.setId(2L);

  
        when(pService.getAll()).thenReturn(Arrays.asList(p1,p2));
        List<PointInteret> pInterets = pInteretController.getAllPointInterets();
        verify(pService).getAll();

        assertEquals(Arrays.asList(p1,p2), pInterets);
    }

    @Test
    public void testGetPointInteretById() {
        final Optional<PointInteret> u = Optional.of(new PointInteret());
        u.get().setId(1L);

        when(pService.getById(1l)).thenReturn(u);
        Optional<PointInteret> pInteret = pInteretController.getPointInteretById(1L);
        verify(pService).getById(1l);

        assertEquals(1l, pInteret.get().getId().longValue());
    }

    @Test
    public void testGetPointInteretCategoryById() {
        final Optional<PointInteret> p = Optional.of(new PointInteret());
        Categorie cat = new Categorie();
        cat.setId(1L);
        p.get().setCategories(Set.of(cat)); 

        when(pService.getCategoryById(1l)).thenReturn(p.get().getCategories());
        Set<Categorie> categories = pInteretController.getPointInteretCategoryById(1L);
        verify(pService).getCategoryById(1l);
        Long id = categories.iterator().next().getId();
        assertEquals(1l, id);
    }
}
