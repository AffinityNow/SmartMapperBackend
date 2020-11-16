package com.smartmapper.core.domain.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import io.micrometer.core.lang.Nullable;


@Entity
public class User {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
    private String name;
    private String login;
    private String password;
    @OneToMany(targetEntity=Favori.class, mappedBy="user", fetch = FetchType.EAGER)
    @Nullable
    private Map<String, Favori> favoris;
    @OneToMany(targetEntity=Itineraire.class, mappedBy="user", fetch = FetchType.EAGER)
    @Nullable
    private Map<String, Itineraire> itineraires;
    @OneToMany(targetEntity=Adresse.class, mappedBy="user", fetch = FetchType.EAGER)
    @Nullable
    private Map<String, Adresse> adresses;


    public User(String name, String login, String password) {
		this.name = name;
		this.login = login;
        this.password = password;
        this.favoris = new HashMap<>();
        this.itineraires = new HashMap<>();
    }
    
    public User(){};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<String, Favori> getFavoris() {
        return favoris;
    }

    public void setFavoris(Map<String, Favori> favoris) {
        this.favoris = favoris;
    }

    
    public Map<String, Itineraire> getItineraires() {
        return itineraires;
    }

    public void setItineraires(Map<String, Itineraire> itineraires) {
        this.itineraires = itineraires;
    }

    
    public Map<String, Adresse> getAdresses() {
        return adresses;
    }

    public void setAdresses(Map<String, Adresse> adresses) {
        this.adresses = adresses;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("User [adresses=");
        builder.append(adresses);
        builder.append(", favoris=");
        builder.append(favoris);
        builder.append(", id=");
        builder.append(id);
        builder.append(", itineraires=");
        builder.append(itineraires);
        builder.append(", login=");
        builder.append(login);
        builder.append(", name=");
        builder.append(name);
        builder.append(", password=");
        builder.append(password);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (login == null) {
            if (other.login != null)
                return false;
        } else if (!login.equals(other.login))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        return true;
    }
}