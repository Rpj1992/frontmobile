package es.acing.dim.frontmobile;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaService {

    private final TareaRepository tareaRepository;

    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public List<Tarea> getListaTareas() {
        return tareaRepository.findAll();
    }

    public Tarea crearTarea(Tarea tarea) {
        tarea.setId(null);
        return tareaRepository.save(tarea);
    }

    public Optional<Tarea> actualizarTarea(long id, Tarea tarea) {
        Optional<Tarea> tareaExistente = tareaRepository.findById(id);

        if (tareaExistente.isPresent()) {
            Tarea t = tareaExistente.get();

            t.setTitulo(tarea.getTitulo());
            t.setCompletada(tarea.isCompletada());

            return Optional.of(tareaRepository.save(t));
        }

        return Optional.empty();
    }

    public boolean eliminarTarea(long id) {
        if (!tareaRepository.existsById(id)) {
            return false;
        }
        tareaRepository.deleteById(id);
        return true;
    }


}
