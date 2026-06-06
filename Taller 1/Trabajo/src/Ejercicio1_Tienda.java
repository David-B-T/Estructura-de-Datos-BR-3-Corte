public class Ejercicio1_Tienda {
    public static void main(String[] args) {
        ArbolNArio<String> arbol = new ArbolNArio<>("Tienda");

        // Agregamos las categorías principales
        arbol.agregarHijo("Tienda", "Tecnologia");
        arbol.agregarHijo("Tienda", "Hogar");
        arbol.agregarHijo("Tienda", "Deportes");

        // Subcategorías
        arbol.agregarHijo("Tecnologia", "Laptops");
        arbol.agregarHijo("Tecnologia", "Celulares");
        arbol.agregarHijo("Tecnologia", "Accesorios");

        arbol.agregarHijo("Hogar", "Cocina");
        arbol.agregarHijo("Hogar", "Muebles");

        arbol.agregarHijo("Deportes", "Futbol");
        arbol.agregarHijo("Deportes", "Ciclismo");

        System.out.println("=== Recorrido en profundidad ===");
        arbol.recorridoProfundidad(arbol.getRaiz());

        System.out.println("\n=== Recorrido por niveles ===");
        arbol.recorridoPorNiveles();

        System.out.println("\nBuscar 'Cocina': " + (arbol.buscar(arbol.getRaiz(), "Cocina") != null));
        System.out.println("Total nodos: " + arbol.contarNodos(arbol.getRaiz()));
        System.out.println("Total hojas: " + arbol.contarHojas(arbol.getRaiz()));
    }
}