package com.smartmapper.core.infra.controller;

import java.util.List;
import java.util.Map;

import com.smartmapper.core.domain.model.Adresse;
import com.smartmapper.core.domain.model.Favori;
import com.smartmapper.core.domain.model.User;
import com.smartmapper.core.infra.repository.UserRepository;
import com.smartmapper.exception.UserNotFoundException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    /**
     * 
     * @return
     */
    @GetMapping("/user")
    List<User> all() {
        return repository.findAll();
    }

    /**
     * 
     * @param id
     * @return
     * @throws UserNotFoundException
     */
    @GetMapping("/user/{id}")
    User one(@PathVariable Long id) throws UserNotFoundException {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    /**
     * 
     * @param id
     * @return
     * @throws UserNotFoundException
     */
    @GetMapping("/user/{id}/itineaires")
    Map<String, Favori> UserItineraire(@PathVariable Long id) throws UserNotFoundException {
        return repository.findById(id).map(user -> user.getItineraires()).orElseThrow(() -> new UserNotFoundException(id));
    }

    @GetMapping("/user/{id}/lieux")
    List<Adresse> UserAdresses((@PathVariable Long id) {

    }


}
