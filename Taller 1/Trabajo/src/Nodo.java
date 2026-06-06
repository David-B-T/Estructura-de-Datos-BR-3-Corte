import java.util.ArrayList;
import java.util.List;

public class Nodo<T> {
    private T dato;
    private List<Nodo<T>> hijos;

    public Nodo(T dato) {
        this.dato = dato;
        this.hijos = new ArrayList<>();
    }

    public T getDato() {
        return dato;
    }

    public List<Nodo<T>> getHijos() {
        return hijos;
    }

    public void agregarHijo(Nodo<T> hijo) {
        hijos.add(hijo);
    }
}