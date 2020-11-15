package com.smartmapper.core.infra.service.serviceImpl;

import java.util.List;
import java.util.Map;

import com.smartmapper.core.domain.model.Adresse;
import com.smartmapper.core.domain.model.Favori;
import com.smartmapper.core.domain.model.Itineraire;
import com.smartmapper.core.domain.model.User;
import com.smartmapper.exception.UserNotFoundException;

public interface UserService{
    List<User> getAll();
    User save(User newUser);
    void delete(long id);
    User findById(long id) throws UserNotFoundException;
    Map<String, Itineraire> findItinerairesById(long id) throws UserNotFoundException;
    Map<String, Adresse> findAdresseById(long id) throws UserNotFoundException;
    void changeName(User user, String newName);
    void changeLogin(User user, String newLogin);
    void changePassword(User user, String newPassword);
    void addFavoris(User user, Favori favori);
    void removeFavoris(User user, Favori favori);
    void addItineraire(User user, Itineraire itineraire);
    void removeItineraire(User user, Itineraire itineraire);
    void addAdresse(User user, Adresse adresse);
    void removeAdresse(User user, Adresse adresse);
}
