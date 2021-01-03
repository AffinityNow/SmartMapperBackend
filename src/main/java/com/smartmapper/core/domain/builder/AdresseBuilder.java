package com.smartmapper.core.domain.builder;

import com.smartmapper.core.domain.model.Adresse;
import com.smartmapper.core.domain.model.PointInteret;

public interface AdresseBuilder {
    AdresseBuilder withCedex(String cedex);
    AdresseBuilder withVille(String ville);
    AdresseBuilder withPays(String pays);
    AdresseBuilder withPoint(PointInteret pInteret);
    AdresseBuilder withCodePostal(String cPostal);
    Adresse build();
	AdresseBuilder withTelephone(String asText);
}
