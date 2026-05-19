package unilibre.edu.consignataria.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dueno {

    @Id
    private String cedula;

    private String nombres;
    private String apellidos;

    @OneToMany(mappedBy = "dueno", cascade = CascadeType.ALL)
    private List<Vehiculo> vehiculos;
}