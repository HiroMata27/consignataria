package unilibre.edu.consignataria.service;

import unilibre.edu.consignataria.model.Dueno;
import unilibre.edu.consignataria.repository.DuenoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DuenoService {

    private final DuenoRepository duenoRepository;

    public List<Dueno> listarTodos() {
        return duenoRepository.findAll();
    }

    public Dueno guardar(Dueno dueno) {
        return duenoRepository.save(dueno);
    }

    public Dueno buscarPorId(String cedula) {
        return duenoRepository.findById(cedula).orElseThrow();
    }

    public void eliminar(String cedula) {
        duenoRepository.deleteById(cedula);
    }
}