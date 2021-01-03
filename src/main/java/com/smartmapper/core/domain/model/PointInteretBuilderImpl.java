package com.smartmapper.core.domain.model;

import java.util.Set;

import com.smartmapper.core.domain.builder.PointInteretBuilder;

public class PointInteretBuilderImpl implements PointInteretBuilder {

    private String name;
    private Coordonnees coordonnes;
    private String description;
    private Adresse adresse;
    private Set<Categorie> categories;

    @Override
    public PointInteretBuilder withAdresse(Adresse adresse) {
        this.adresse = adresse;
        return this;
    }

    @Override
    public PointInteretBuilder withCategorie(Set<Categorie> categories) {
        this.categories = categories;
        return this;
    }

    @Override
    public PointInteret build() {
        return new PointInteret(this.name, this.coordonnes, this.description, this.adresse, this.categories);
    }

    public PointInteretBuilderImpl(String name, Coordonnees coordonnes, String description) {
        this.name = name;
        this.coordonnes = coordonnes;
        this.description = description;
    }
}
