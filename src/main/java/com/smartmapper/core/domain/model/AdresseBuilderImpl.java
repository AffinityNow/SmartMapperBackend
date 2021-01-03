package com.smartmapper.core.domain.model;

import com.smartmapper.core.domain.builder.AdresseBuilder;

public class AdresseBuilderImpl implements AdresseBuilder {

    private String name;
    private String lines;
    private String cedex;
    private String codePostal;
    private String ville;
    private String pays;
    private PointInteret point;
    private String telephone;

    @Override
    public AdresseBuilder withCedex(String cedex) {
        this.cedex = cedex;
        return this;
    }

    @Override
    public AdresseBuilder withVille(String ville) {
        this.ville = ville;
        return this;
    }

    @Override
    public AdresseBuilder withPays(String pays) {
        this.pays = pays;
        return this;
    }

    @Override
    public AdresseBuilder withPoint(PointInteret pInteret) {
        this.point = pInteret;
        return this;
    }

    @Override
    public AdresseBuilder withCodePostal(String cpString) {
        this.codePostal = cpString;
        return this;
    }

    @Override
    public Adresse build() {
        return new Adresse(this.name, this.lines, this.cedex, this.codePostal, this.ville, this.pays, this.point,
                this.telephone);
    }

    public AdresseBuilderImpl(String name, String lines) {
        this.name = name;
        this.lines = lines;
    }

    @Override
    public AdresseBuilder withTelephone(String asText) {
        this.telephone = asText;
        return this;
    }
}
