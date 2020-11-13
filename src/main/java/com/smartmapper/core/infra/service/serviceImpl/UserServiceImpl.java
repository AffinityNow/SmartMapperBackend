package com.smartmapper.core.infra.service.serviceImpl;

import com.smartmapper.core.domain.model.Adresse;
import com.smartmapper.core.domain.model.Favori;
import com.smartmapper.core.domain.model.Itineraire;
import com.smartmapper.core.domain.model.User;

public class UserServiceImpl implements UserService {

    @Override
    public void changeName(User user, String newName) {
        user.setName(newName);
    }

    @Override
    public void changeLogin(User user, String newLogin) {
        user.setLogin(newLogin);
    }

    @Override
    public void changePassword(User user, String newPassword) {
        user.setPassword(newPassword);
    }

    @Override
    public void addFavoris(User user, Favori favori) {
        user.getFavoris().put(favori.getName(), favori);
    }

    @Override
    public void removeFavoris(User user, Favori favori) {
        user.getFavoris().remove(favori.getName());
    }

    @Override
    public void addItineraire(User user, Itineraire itineraire) {
        user.getItineraires().put(itineraire.getName(), itineraire);
    }

    @Override
    public void removeItineraire(User user, Itineraire itineraire) {
        user.getItineraires().remove(itineraire.getName());
    }

    @Override
    public void addAdresse(User user, Adresse adresse) {
        user.getAdresses().put(adresse.getName(), adresse);
    }

    @Override
    public void removeAdresse(User user, Adresse adresse) {
        user.getAdresses().remove(adresse.getName());
    }
}
