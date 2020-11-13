package com.smartmapper.core.infra.repository;

import java.util.List;
import com.smartmapper.core.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    List<User> findByName(String name);
    User findById(long id);
}



