package com.agenda.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.agenda.modelo.entidad.Carro;
import com.agenda.modelo.servicio.ICarroServicio;

@Controller
@RequestMapping("/vistas/carros")
public class ControladorCarro {
    @Autowired
    private ICarroServicio carroServicio;

    @GetMapping("/")
    public String listarCarros(Model modelo) {
        List<Carro> listadoCarros = carroServicio.listaTodos();
        modelo.addAttribute("carros", listadoCarros);
        return "/vistas/carros/listar";
    }

    @GetMapping("/create")
    public String crear(Model modelo) {
        Carro carro = new Carro();
        modelo.addAttribute("Titulo", "Formulario: Nuevo Carro");
        modelo.addAttribute("carro", carro);
        return "/vistas/carros/registrocarro";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute Carro carro, Model modelo) {
        modelo.addAttribute("Titulo", "Formulario: Nuevo Carro");
        modelo.addAttribute("carro", carro);
        carroServicio.guardar(carro);
        return "redirect:/vistas/carros/";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") int idCarro, Model modelo) {
        Carro carro = new Carro();
        if (idCarro > 0) {
            carro = carroServicio.buscarPorId(idCarro);
            if (carro == null) {
                return "redirect:/vistas/carros/";
            }
        } else {
            return "redirect:/vistas/carros/";
        }
        modelo.addAttribute("Titulo", "Formulario: Editar Carro");
        modelo.addAttribute("carro", carro);
        return "/vistas/carros/registrocarro";
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Integer idCarro) {
        Carro carro = new Carro();
        if (idCarro > 0) {
            carro = carroServicio.buscarPorId(idCarro);
            if (carro == null) {
                return "redirect:/vistas/carros/";
            }
        } else {
            return "redirect:/vistas/carros/";
        }
        carroServicio.eliminar(idCarro);
        return "redirect:/vistas/carros/";
    }
}
