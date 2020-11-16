package com.smartmapper.core.infra.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.smartmapper.core.domain.model.Adresse;
import com.smartmapper.core.domain.model.Itineraire;
import com.smartmapper.core.domain.model.User;
import com.smartmapper.core.infra.service.serviceImpl.UserService;
import com.smartmapper.exception.UserNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return service.getAll();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id) throws UserNotFoundException {
        return service.findById(id);
    }

    @GetMapping("/user/{id}/itineaires")
    public Map<String, Itineraire> getUserItineraires(@PathVariable Long id) {
        Map<String, Itineraire> newMap = new HashMap<>();
        try {
            newMap = service.findItinerairesById(id);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        return newMap;
    }

    @GetMapping("/user/{id}/adresses")
    public Map<String, Adresse> getUserAdresses(@PathVariable Long id)  {
        Map<String, Adresse> newMap = new HashMap<>();
        try {
            newMap = service.findAdresseById(id);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        return newMap;
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User newUser) {
        return service.save(newUser);
    }

    @PutMapping("/user/{id}")
    public User replaceUser(@RequestBody User newUser, @PathVariable Long id) {
        return service.replaceUser(newUser, id);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.delete(id);
    }
}
