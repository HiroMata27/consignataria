package unilibre.edu.consignataria.controller;

import unilibre.edu.consignataria.model.Vehiculo;
import unilibre.edu.consignataria.service.DuenoService;
import unilibre.edu.consignataria.service.VehiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vehiculos")
@RequiredArgsConstructor
public class VehiculoController {

    private final VehiculoService vehiculoService;
    private final DuenoService duenoService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("vehiculos", vehiculoService.listarTodos());
        return "vehiculos-lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("vehiculo", new Vehiculo());
        model.addAttribute("duenos", duenoService.listarTodos());
        return "vehiculos-formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Vehiculo vehiculo,
                          @RequestParam String duenoCedula) {
        vehiculo.setDueno(duenoService.buscarPorId(duenoCedula));
        vehiculoService.guardar(vehiculo);
        return "redirect:/vehiculos";
    }

    @GetMapping("/vender/{placa}")
    public String vender(@PathVariable String placa) {
        vehiculoService.vender(placa);
        return "redirect:/vehiculos";
    }

    @GetMapping("/eliminar/{placa}")
    public String eliminar(@PathVariable String placa) {
        vehiculoService.eliminar(placa);
        return "redirect:/vehiculos";
    }
}