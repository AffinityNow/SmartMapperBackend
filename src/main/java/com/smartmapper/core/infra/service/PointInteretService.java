package com.smartmapper.core.infra.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.smartmapper.core.domain.model.Categorie;
import com.smartmapper.core.domain.model.PointInteret;

public interface PointInteretService {
    List<PointInteret> getAll();
    Optional<PointInteret> getById(Long id);
    void save(PointInteret newUser);
    Set<Categorie> getCategoryById(Long id);
    List<PointInteret> getByCategory(String categorie);
}
