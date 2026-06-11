package es.acing.dim.frontmobile;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}
