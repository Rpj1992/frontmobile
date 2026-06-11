package es.acing.dim.frontmobile;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TareaController {

    public TareaController() {
    }

    @GetMapping("/tareas")
    public List<Tarea> getTareas() {
        List<Tarea> listaTareas = new ArrayList<>();
        listaTareas.add(new Tarea());
        listaTareas.add(new Tarea());
        listaTareas.add(new Tarea());
        return listaTareas;
    }
}
