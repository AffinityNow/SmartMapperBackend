package com.smartmapper.core.infra.service.serviceImpl;

import com.smartmapper.core.domain.model.Adresse;
import com.smartmapper.core.domain.model.Favori;
import com.smartmapper.core.domain.model.Itineraire;
import com.smartmapper.core.domain.model.User;

public interface UserService{
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
