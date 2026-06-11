package es.acing.dim.frontmobile;

public class Tarea {

    private long id;
    private String titulo;
    private boolean completada;

    public Tarea() {
        id = 1;
        titulo = "patata";
        completada = true;
    }

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }
}
