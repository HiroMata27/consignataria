package unilibre.edu.consignataria.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehiculo {

    @Id
    private String placa;

    private String modelo;
    private String color;
    private Double valorCompra;

    @Enumerated(EnumType.STRING)
    private EstadoVehiculo estado;

    @ManyToOne
    @JoinColumn(name = "dueno_cedula")
    private Dueno dueno;

    public Double getValorVenta() {
        return valorCompra * 1.20;
    }
}