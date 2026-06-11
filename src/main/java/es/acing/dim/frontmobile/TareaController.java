package es.acing.dim.frontmobile;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TareaController {

    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @GetMapping("/tareas")
    public List<Tarea> getTareas() {
        List<Tarea> listaTareas = tareaService.getListaTareas();
        return listaTareas;
    }

    @PostMapping("/tareas")
    public ResponseEntity<Tarea> postTarea(@RequestBody Tarea tarea) {
        Tarea tareaCreada = tareaService.crearTarea(tarea);
        return ResponseEntity.status(HttpStatus.CREATED).body(tareaCreada);
    }

    @PutMapping("/tareas/{id}")
    public ResponseEntity<Optional<Tarea>> putTarea(@PathVariable long id, @RequestBody Tarea tarea) {
        Optional<Tarea> tareaActualizada = tareaService.actualizarTarea(id, tarea);

        if (tareaActualizada.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(tareaActualizada);
    }

    @DeleteMapping("/tareas/{id}")
    public ResponseEntity<Void> deleteTarea(@PathVariable long id) {

        boolean eliminida = tareaService.eliminarTarea(id);

        if (!eliminida) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }


}
