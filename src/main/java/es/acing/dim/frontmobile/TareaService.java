package es.acing.dim.frontmobile;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TareaService {

    private List<Tarea> listaTareas;

    public TareaService() {
        this.listaTareas = new ArrayList<>();
        listaTareas.add(new Tarea());
        listaTareas.add(new Tarea());
        listaTareas.add(new Tarea());
    }

    public List<Tarea> getListaTareas() {
        return listaTareas;
    }

    public void setListaTareas(List<Tarea> listaTareas) {
        this.listaTareas = listaTareas;
    }

    public Tarea crearTarea(Tarea tarea) {
        Tarea tareaCreada = tarea;
        tareaCreada.setId(listaTareas.get(listaTareas.size()-1).getId()+1);
        listaTareas.add(tareaCreada);
        return tareaCreada;
    }

    public Optional<Tarea> actualizarTarea(long id, Tarea tarea) {
        for (Tarea t : listaTareas) {
            if (t.getId() == id) {
                t.setCompletada(tarea.isCompletada());
                t.setTitulo(tarea.getTitulo());
                return Optional.of(t);
            }
        }
        return Optional.empty();
    }

    public boolean eliminarTarea(long id) {
        for (int i = 0;i < listaTareas.size(); i++) {
            if (listaTareas.get(i).getId() == id) {
                listaTareas.remove(i);
                return true;
            }
        }
        return false;
    }


}
