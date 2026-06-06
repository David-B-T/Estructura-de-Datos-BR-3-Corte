import java.util.Scanner;

public class Ejercicio2_Carpetas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArbolNArio<String> empresa = new ArbolNArio<>("Empresa");

        // Datos iniciales
        empresa.agregarHijo("Empresa", "Documentos");
        empresa.agregarHijo("Empresa", "Recursos Humanos");
        empresa.agregarHijo("Empresa", "Tecnologia");

        empresa.agregarHijo("Documentos", "Informes");
        empresa.agregarHijo("Documentos", "Contratos");
        empresa.agregarHijo("Documentos", "Manuales");

        empresa.agregarHijo("Recursos Humanos", "Hojas de vida");
        empresa.agregarHijo("Recursos Humanos", "Nomina");

        empresa.agregarHijo("Tecnologia", "Soporte");
        empresa.agregarHijo("Tecnologia", "Inventario");
        empresa.agregarHijo("Tecnologia", "Seguridad");

        int opcion;

        do {
            System.out.println("\n===== SISTEMA JERARQUICO DE CARPETAS =====");
            System.out.println("1. Mostrar estructura de carpetas");
            System.out.println("2. Buscar carpeta");
            System.out.println("3. Contar total de carpetas");
            System.out.println("4. Contar carpetas finales");
            System.out.println("5. Agregar nueva carpeta");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.println("\nEstructura de carpetas:");
                    empresa.mostrarEstructura(empresa.getRaiz(), 0);
                    break;
                case 2:
                    System.out.print("\nIngrese el nombre de la carpeta a buscar: ");
                    String nombreBuscar = sc.nextLine();
                    boolean existe = empresa.buscar(empresa.getRaiz(), nombreBuscar) != null;
                    System.out.println("La carpeta \"" + nombreBuscar + (existe ? "\" SI existe." : "\" NO existe."));
                    break;
                case 3:
                    System.out.println("\nTotal de carpetas: " + empresa.contarNodos(empresa.getRaiz()));
                    break;
                case 4:
                    System.out.println("\nTotal de carpetas finales: " + empresa.contarHojas(empresa.getRaiz()));
                    break;
                case 5:
                    System.out.print("\nIngrese el nombre de la carpeta padre: ");
                    String padre = sc.nextLine();
                    System.out.print("Ingrese el nombre de la nueva carpeta: ");
                    String nuevaCarpeta = sc.nextLine();
                    if (empresa.agregarHijo(padre, nuevaCarpeta)) {
                        System.out.println("Carpeta agregada correctamente.");
                    } else {
                        System.out.println("No se encontro la carpeta padre.");
                    }
                    break;
                case 0:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}