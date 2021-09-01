package dev.nemowave.cinedatabase.repository;

import dev.nemowave.cinedatabase.model.Writer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WriterRepository extends JpaRepository<Writer, Long> {
    Optional<Writer> findByName(String name);
}
