package dev.nemowave.cinedatabase.repository;

import dev.nemowave.cinedatabase.model.Star;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StarRepository extends JpaRepository<Star, Long> {
    Optional<Star> findByName(String name);
}
