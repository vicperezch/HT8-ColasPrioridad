package src;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.PriorityQueue;

/**
 * @author Victor Pérez
 * @since 24/03/2024
 * Clase principal donde se ejecuta el programa
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Reader reader = new Reader("pacientes.txt");

        Heap<Patient> patientsHeap = new Heap<>();
        PriorityQueue<Patient> patientsQueue = new PriorityQueue<>();
        boolean isHeap = false;
        boolean isQueue = false;

        // Menú para seleccionar la implementación a utilizar
        boolean runImpMenu = true;
        while (runImpMenu) {
            System.out.println("--- Selección de implementación ---");
            System.out.println("1. CustomHeap");
            System.out.println("2. PriorityQueue de Java Collections Framework");
            System.out.print("Seleccione una opción: ");

            try {
                int option = sc.nextInt();
                sc.nextLine();

                switch (option) {
                    case 1:
                        patientsHeap = reader.readCustomHeap();
                        runImpMenu = false;
                        isHeap = true;
                        break;

                    case 2:
                        patientsQueue = reader.readPriorityQueue();
                        runImpMenu = false;
                        isQueue = true;
                        break;
                
                    default:
                        System.out.println("Opción inválida\n");
                        break;
                }

            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Opción inválida\n");
            }
        }

        // Menú para atender a los pacientes
        boolean runMainMenu = true;
        while (runMainMenu) {
            System.out.println("\n--- Sistema de emergencias ---");
            System.out.println("1. Ver siguiente paciente");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                int option = sc.nextInt();
                sc.nextLine();

                switch (option) {
                    case 1:
                        Patient patient = null;

                        if (isHeap) {
                            patient = patientsHeap.remove();

                        } else if (isQueue) {
                            patient = patientsQueue.poll();
                        }

                        if (patient != null) {
                            System.out.println("\nPaciente atendido");
                            System.out.println("Nombre: " + patient.getName());
                            System.out.println("Motivo: " + patient.getMotive());
                            System.out.println("Prioridad: " + patient.getPriority());

                        } else {
                            System.out.println("\nNo hay pacientes en la cola");
                        }
                        
                        break;

                    case 2:
                        runMainMenu = false;
                        break;
                
                    default:
                        System.out.println("Opción inválida");
                        break;
                }

            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Opción inválida");
            }
        }

        sc.close();
    }
}