package com.smartmapper.core.infra.service.serviceImpl;

import java.util.List;
import java.util.Map;
import com.smartmapper.core.domain.model.Adresse;
import com.smartmapper.core.domain.model.Favori;
import com.smartmapper.core.domain.model.Itineraire;
import com.smartmapper.core.domain.model.User;
import com.smartmapper.core.infra.repository.UserRepository;
import com.smartmapper.exception.UserNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

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

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User save(User newUser) {
        return repository.save(newUser);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public User findById(long id) throws UserNotFoundException {
        User newUser = repository.findById(id);
        if(newUser == null)
            throw new UserNotFoundException(id);
        else
            return newUser;
    }

    @Override
    public Map<String, Itineraire> findItinerairesById(long id) throws UserNotFoundException {
        User newUser = repository.findById(id);
        if(newUser == null)
            throw new UserNotFoundException(id);
        else
            return newUser.getItineraires();
    }

    @Override
    public Map<String, Adresse> findAdresseById(long id) throws UserNotFoundException {
        User newUser = repository.findById(id);
        if(newUser == null)
            throw new UserNotFoundException(id);
        else
            return newUser.getAdresses();
    }

    @Override
    public User replaceUser(User newUser, long id) {
        User user = repository.findById(id);

        if(newUser.getName() != null)
            user.setName(newUser.getName());

        if(newUser.getLogin() != null)
            user.setLogin(newUser.getLogin());

        if(newUser.getPassword() != null)
            user.setPassword(newUser.getPassword());

        if(newUser.getAdresses() != null)
            user.setAdresses(newUser.getAdresses());
            
        if(newUser.getItineraires() != null)    
            user.setItineraires(newUser.getItineraires());

        if(newUser.getFavoris() != null)
            user.setFavoris(newUser.getFavoris());

        return this.save(user);
    }
}
