package unilibre.edu.consignataria.repository;

import unilibre.edu.consignataria.model.Dueno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DuenoRepository extends JpaRepository<Dueno, String> {
}