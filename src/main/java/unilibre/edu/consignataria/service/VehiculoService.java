package unilibre.edu.consignataria.service;

import unilibre.edu.consignataria.model.EstadoVehiculo;
import unilibre.edu.consignataria.model.Vehiculo;
import unilibre.edu.consignataria.repository.VehiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    public List<Vehiculo> listarTodos() {
        return vehiculoRepository.findAll();
    }

    public List<Vehiculo> listarDisponibles() {
        return vehiculoRepository.findByEstado(EstadoVehiculo.DISPONIBLE);
    }

    public Vehiculo guardar(Vehiculo vehiculo) {
        vehiculo.setEstado(EstadoVehiculo.DISPONIBLE);
        return vehiculoRepository.save(vehiculo);
    }

    public void vender(String placa) {
        Vehiculo v = vehiculoRepository.findById(placa).orElseThrow();
        v.setEstado(EstadoVehiculo.VENDIDO);
        vehiculoRepository.save(v);
    }

    public Vehiculo buscarPorId(String placa) {
        return vehiculoRepository.findById(placa).orElseThrow();
    }

    public void eliminar(String placa) {
        vehiculoRepository.deleteById(placa);
    }
}