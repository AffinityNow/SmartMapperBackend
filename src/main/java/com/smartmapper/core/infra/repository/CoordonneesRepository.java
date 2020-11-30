package com.smartmapper.core.infra.repository;

import com.smartmapper.core.domain.model.Coordonnees;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordonneesRepository extends JpaRepository<Coordonnees, Long> {
    
}
