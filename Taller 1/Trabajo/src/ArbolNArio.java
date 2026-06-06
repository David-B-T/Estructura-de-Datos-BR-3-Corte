import java.util.LinkedList;
import java.util.Queue;

public class ArbolNArio<T> {
    private Nodo<T> raiz;

    public ArbolNArio(T datoRaiz) {
        raiz = new Nodo<>(datoRaiz);
    }

    public Nodo<T> getRaiz() {
        return raiz;
    }

    public Nodo<T> buscar(Nodo<T> actual, T valorBuscado) {
        if (actual == null) return null;
        
        if (actual.getDato().equals(valorBuscado)) {
            return actual;
        }

        for (Nodo<T> hijo : actual.getHijos()) {
            Nodo<T> encontrado = buscar(hijo, valorBuscado);
            if (encontrado != null) return encontrado;
        }
        return null;
    }

    public boolean agregarHijo(T datoPadre, T datoNuevo) {
        Nodo<T> padre = buscar(raiz, datoPadre);
        if (padre != null) {
            padre.agregarHijo(new Nodo<>(datoNuevo));
            return true;
        }
        return false;
    }

    public void recorridoProfundidad(Nodo<T> nodo) {
        if (nodo == null) return;
        System.out.println(nodo.getDato());
        for (Nodo<T> hijo : nodo.getHijos()) {
            recorridoProfundidad(hijo);
        }
    }

    public void recorridoPorNiveles() {
        if (raiz == null) return;
        Queue<Nodo<T>> cola = new LinkedList<>();
        cola.add(raiz);
        
        while (!cola.isEmpty()) {
            Nodo<T> actual = cola.poll();
            System.out.println(actual.getDato());
            for (Nodo<T> hijo : actual.getHijos()) {
                cola.add(hijo);
            }
        }
    }

    public void mostrarEstructura(Nodo<T> actual, int nivel) {
        if (actual == null) return;
        for (int i = 0; i < nivel; i++) {
            System.out.print("   ");
        }
        System.out.println("- " + actual.getDato());
        for (Nodo<T> hijo : actual.getHijos()) {
            mostrarEstructura(hijo, nivel + 1);
        }
    }

    public int contarNodos(Nodo<T> nodo) {
        if (nodo == null) return 0;
        int total = 1;
        for (Nodo<T> hijo : nodo.getHijos()) {
            total += contarNodos(hijo);
        }
        return total;
    }

    public int contarHojas(Nodo<T> nodo) {
        if (nodo == null) return 0;
        if (nodo.getHijos().isEmpty()) return 1;
        int hojas = 0;
        for (Nodo<T> hijo : nodo.getHijos()) {
            hojas += contarHojas(hijo);
        }
        return hojas;
    }
}