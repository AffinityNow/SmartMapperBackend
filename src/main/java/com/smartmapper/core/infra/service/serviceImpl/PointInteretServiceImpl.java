package com.smartmapper.core.infra.service.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.smartmapper.core.domain.model.Categorie;
import com.smartmapper.core.domain.model.PointInteret;
import com.smartmapper.core.infra.repository.PointInteretRepository;
import com.smartmapper.core.infra.service.PointInteretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointInteretServiceImpl implements PointInteretService {

    private PointInteretRepository repository;

    public PointInteretServiceImpl(PointInteretRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PointInteret> getAll() {
        return repository.findAll();
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

    @Override
    public List<PointInteret> getByCategory(String categorie) {
        return repository.findAll().stream()
                .filter(p -> p.getCategories().stream().anyMatch(c -> c.getName().equals(categorie)))
                .collect(Collectors.toList());
    }

    //Ahlem
    @Override
    public List<PointInteret> getByCategoryandByPosition(String categorie, double lat, double lg) {
        return getByCategory(categorie).stream()
                .sorted((p1, p2) -> {
                    double dis1 = distance(p1.getCoordonnes().getLatitude(), p1.getCoordonnes().getLongitude(), lat, lg);
                    double dis2 = distance(p2.getCoordonnes().getLatitude(), p2.getCoordonnes().getLongitude(), lat, lg);
                    return Double.compare(dis1, dis2);
                })
                .collect(Collectors.toList());
    }

    //  d = √((x2 - x1)^2 + (y2 - y1)^2)
    public double distance(double latA, double lgA, double latP, double lgP) {
        double dLat = latA - latP;
        double dLg = lgA - lgP;
        return Math.sqrt(dLat * dLat + dLg * dLg);
    }

}

