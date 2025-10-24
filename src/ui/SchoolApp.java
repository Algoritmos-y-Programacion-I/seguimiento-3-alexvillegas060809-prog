package ui;
import model.SchoolController;

import model.Computador;
import java.util.Scanner;

public class SchoolApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SchoolController controller = new SchoolController();


        int opcion;
        do {
           System.out.println("\n ESCUELA COMPUTARICEMOS ");
            System.out.println("1. Agregar computador");
            System.out.println("2. Reportar incidente");
            System.out.println("3. Consultar computador con más incidentes");
            System.out.println("4. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Serial del computador: ");
                    String serial = sc.nextLine();
                    System.out.print("Piso (1-5): ");
                    int piso = sc.nextInt();
                    sc.nextLine();

                    if (controller.agregarComputador(serial, piso)) {

                        System.out.println(" Computador agregado correctamente.");
                    } else {
                        System.out.println(" Error: piso lleno o serial duplicado.");
                    }
                    break;

                case 2:
                    System.out.print("Serial del computador: ");
                    serial = sc.nextLine();
                    System.out.print("Descripcin del incidente: ");
                    String desc = sc.nextLine();

                    if (controller.registrarIncidente(serial, desc)) {
                        System.out.println(" Incidente registrado correctamente.");
                    } else {
                        System.out.println(" Computador no encontrado.");
                    }
                    break;

                case 3:
                    Computador max = controller.computadorConMasIncidentes();
                    if (max != null) {
                        System.out.println("\nComputador con más incidentes:");
                        System.out.println("Serial: " + max.getSerial());
                        System.out.println("Piso: " + max.getPiso());
                        System.out.println("Columna: " + max.getColumna());
                        System.out.println("Incidentes: " + max.getCantidadIncidentes());
                    } else {
                        System.out.println(" No hay computadores registrados.");
                    }
                    break;

                case 4:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println(" Opcion invalida.");
                    break;
            }

        } while (opcion != 4);

        sc.close();
    }
}
