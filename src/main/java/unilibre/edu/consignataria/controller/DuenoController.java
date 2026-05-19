package unilibre.edu.consignataria.controller;

import unilibre.edu.consignataria.model.Dueno;
import unilibre.edu.consignataria.service.DuenoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/duenos")
@RequiredArgsConstructor
public class DuenoController {

    private final DuenoService duenoService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("duenos", duenoService.listarTodos());
        return "duenos-lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("dueno", new Dueno());
        return "duenos-formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Dueno dueno) {
        duenoService.guardar(dueno);
        return "redirect:/duenos";
    }

    @GetMapping("/eliminar/{cedula}")
    public String eliminar(@PathVariable String cedula) {
        duenoService.eliminar(cedula);
        return "redirect:/duenos";
    }
}