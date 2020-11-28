package com.smartmapper.core.infra.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import com.smartmapper.core.domain.model.Adresse;
import com.smartmapper.core.domain.model.Itineraire;
import com.smartmapper.core.domain.model.User;
import com.smartmapper.core.infra.controller.UserController;
import com.smartmapper.core.infra.service.serviceImpl.UserService;
import com.smartmapper.exception.UserNotFoundException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetUserById() {
        final User u = new User();
        u.setId(1L);

        try {
            when(userService.findById(1l)).thenReturn(u);
            User user = userController.getUserById(1L);
            verify(userService).findById(1l);

            assertEquals(1l, user.getId().longValue());
        } catch (UserNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    @Test
    public void testGetUserItineraires() {
        final User u = new User();
        u.setId(2L);
        Map<String, Itineraire> itineraire = new HashMap<>();
        u.setItineraires(itineraire);

        try {
            when(userService.findItinerairesById(2l)).thenReturn(u.getItineraires());
            Map<String, Itineraire> itineraires = userController.getUserItineraires(2L);
            verify(userService).findItinerairesById(2l);

            assertEquals(itineraire,itineraires);
        } catch (UserNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    @Test
    public void testGetUserAdresses() {
        final User u = new User();
        u.setId(2L);
        Map<String, Adresse> adresse = new HashMap<>();
        u.setAdresses(adresse);

        try {
            when(userService.findAdresseById(2l)).thenReturn(u.getAdresses());
            Map<String, Adresse> adresses = userController.getUserAdresses(2L);
            verify(userService).findAdresseById(2l);

            assertEquals(adresse,adresses);
        } catch (UserNotFoundException e2) {
            e2.printStackTrace();
        }
    }
}
