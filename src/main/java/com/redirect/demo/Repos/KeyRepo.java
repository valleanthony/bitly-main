package com.redirect.demo.Repos;

import com.redirect.demo.Model.WebKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface KeyRepo extends JpaRepository<WebKey,Long> {

    Optional<WebKey> findByKey(String Key);
    boolean existsByKey(String Key);

}
