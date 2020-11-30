package com.smartmapper.core.domain.builder;

import com.smartmapper.core.domain.model.Adresse;
import com.smartmapper.core.domain.model.PointInteret;
import com.smartmapper.core.domain.model.User;

public interface AdresseBuilder {
    AdresseBuilder withCedex(String cedex);
    AdresseBuilder withVille(String ville);
    AdresseBuilder withPays(String pays);
    AdresseBuilder withUser(User User);
    AdresseBuilder withPoint(PointInteret pInteret);
    AdresseBuilder withCodePostal(String cPostal);
    AdresseBuilder withTelephone(String telephone);
    Adresse build();
}
