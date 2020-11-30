package com.smartmapper.core.infra.repository;

import com.smartmapper.core.domain.model.Adresse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface AdresseRepository extends JpaRepository<Adresse, Long> {
    
}
