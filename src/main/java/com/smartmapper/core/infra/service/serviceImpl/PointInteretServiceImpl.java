package com.smartmapper.core.infra.service.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.smartmapper.core.domain.model.Categorie;
import com.smartmapper.core.domain.model.PointInteret;
import com.smartmapper.core.infra.repository.PointInteretRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointInteretServiceImpl implements PointInteretService {

    @Autowired
    private PointInteretRepository repository;

    @Override
    public List<PointInteret> getAll() {
        return repository.findAll();
    }

    @Override
    public List<PointInteret> getByCategory(String categorie) {
        return repository.findAll().stream()
                .filter(p -> p.getCategories().stream().anyMatch(c -> c.getName().equals(categorie)))
                .collect(Collectors.toList());
    }

    @Override
    public void save(PointInteret newPointInteret) {
        repository.save(newPointInteret);
    }

    @Override
    public Optional<PointInteret> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Set<Categorie> getCategoryById(Long id) {
        return repository.getOne(id).getCategories();
    }
    
}
