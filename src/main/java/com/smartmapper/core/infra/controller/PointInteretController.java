package com.smartmapper.core.infra.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.smartmapper.core.domain.model.Categorie;
import com.smartmapper.core.domain.model.PointInteret;
import com.smartmapper.core.infra.service.PointInteretService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PointInteretController {

    @Autowired
    private final PointInteretService service;

    public PointInteretController(PointInteretService service) {
        this.service = service;
    }

    @GetMapping("/point-interet")
    public List<PointInteret> getAllPointInterets() {
        return service.getAll();
    }

    @GetMapping("/point-interet/{id}")
    public Optional<PointInteret> getPointInteretById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/point-interet/{id}/categorie")
    public Set<Categorie> getPointInteretCategoryById(@PathVariable Long id) {
        return service.getCategoryById(id);
    }

    @CrossOrigin
    @GetMapping("/point-interet/categorie/{categorie}/{lat}/{lg}")
    public List<PointInteret> getPointInteretByCategoriePosition(@PathVariable String categorie,
                                                                 @PathVariable double lat,
                                                                 @PathVariable double lg
    ) {
        return service.getByCategoryandByPosition(categorie, lat, lg);
    }
}
