package com.smartmapper.core.domain.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.springframework.lang.Nullable;


@Entity
public class PointInteret {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToOne(targetEntity = Coordonnees.class, cascade=CascadeType.ALL)
    @JsonManagedReference
    private Coordonnees coordonnes;
    @Column(length = 1000)
    private String description;
    @OneToOne(targetEntity = Adresse.class, cascade=CascadeType.ALL)
    @JsonManagedReference
    private Adresse adresse;
    @OneToMany(targetEntity=Categorie.class, mappedBy="point", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @Nullable
    @JsonManagedReference
    private Set<Categorie> categories;

    

    public Set<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(Set<Categorie> categories) {
        this.categories = categories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordonnees getCoordonnes() {
        return coordonnes;
    }

    public void setCoordonnes(Coordonnees coordonnes) {
        this.coordonnes = coordonnes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PointInteret [coordonnes=");
        builder.append(coordonnes);
        builder.append(", description=");
        builder.append(description);
        builder.append(", name=");
        builder.append(name);
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((coordonnes == null) ? 0 : coordonnes.hashCode());
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
        PointInteret other = (PointInteret) obj;
        if (coordonnes == null) {
            if (other.coordonnes != null)
                return false;
        } else if (!coordonnes.equals(other.coordonnes))
            return false;
        return true;
    }

    public void addCategorie(Categorie c) {
        categories.add(c);
        c.setPointInteret(this);
    }

    public void removeCategorie(Categorie c) {
        categories.remove(c);
        c.setPointInteret(null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    PointInteret(String name, Coordonnees coordonnes, String description, Adresse adresse,
            Set<Categorie> categories) {
        this.name = name;
        this.coordonnes = coordonnes;
        this.description = description;
        this.adresse = adresse;
        this.categories = categories;
    }

    public PointInteret() {
    }
}
