package com.smartmapper.core.infra.repository;

import com.smartmapper.core.domain.model.Categorie;
import com.smartmapper.core.domain.model.PointInteret;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointInteretRepository extends JpaRepository<PointInteret, Long> {
    PointInteret findByCategories(Categorie categorie);
}
