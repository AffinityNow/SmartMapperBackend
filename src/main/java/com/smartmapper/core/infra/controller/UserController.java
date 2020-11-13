package com.smartmapper.core.infra.controller;

import java.util.List;
import java.util.Map;
import com.smartmapper.core.domain.model.Adresse;
import com.smartmapper.core.domain.model.Favori;
import com.smartmapper.core.domain.model.Itineraire;
import com.smartmapper.core.domain.model.User;
import com.smartmapper.core.infra.repository.UserRepository;
import com.smartmapper.core.infra.service.serviceImpl.UserService;
import com.smartmapper.exception.UserNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserRepository repository;
    private final UserService service;

    public UserController(UserRepository repository, UserService service) {
        this.repository = repository;
        this.service = service;
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
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    /**
     * 
     * @param id
     * @return
     * @throws UserNotFoundException
     */
    @GetMapping("/user/{id}/itineaires")
    Map<String, Itineraire> itineraire(@PathVariable Long id) throws UserNotFoundException {
        return repository.findById(id)
                .map(user -> user.getItineraires())
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    /**
     * 
     * @param id
     * @return
     * @throws UserNotFoundException
     */
    @GetMapping("/user/{id}/lieux")
    Map<String, Adresse> adresses(@PathVariable Long id) throws UserNotFoundException {
        return repository.findById(id)
                .map(user -> user.getAdresses())
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    /**
     * 
     * @param newUser
     * @return
     */
    @PostMapping("/user")
    User createUser(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    /**
     * 
     * @param id
     */
    @PutMapping("/user/{id}")
    User replaceUser(@RequestBody User newUser, @PathVariable Long id) {
        // TODO
        return null;
    }

    /**
     * 
     * @param id
     */
    @DeleteMapping("/user/{id}")
    void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
