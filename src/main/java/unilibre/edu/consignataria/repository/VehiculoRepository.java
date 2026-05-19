package unilibre.edu.consignataria.repository;

import unilibre.edu.consignataria.model.Vehiculo;
import unilibre.edu.consignataria.model.EstadoVehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VehiculoRepository extends JpaRepository<Vehiculo, String> {
    List<Vehiculo> findByEstado(EstadoVehiculo estado);
}