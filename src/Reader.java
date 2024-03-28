package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

/**
 * @author Victor Pérez
 * @since 28/03/2024
 * Clase encargada de leer el archivo con datos de los pacientes
 */
public class Reader {
    private File patientsFile;

    /**
     * Constructor de la clase
     * @param name Nombre del archivo
     */
    public Reader(String name) {
        this.patientsFile = new File(name);
    }


    /**
     * Lee el archivo con los datos de los pacientes y los almacena en el heap
     * @return Heap con los pacientes
     */
    public Heap<Patient> readCustomHeap() {
        Heap<Patient> patients = new Heap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(patientsFile));
            String line = br.readLine();

            while (line != null) {
                String[] data = line.split(",");

                // Elimina espacios en blanco
                if (data[1].startsWith(" ")) {
                    data[1] = data[1].substring(1);
                }

                if (data[2].startsWith(" ")) {
                    data[2] = data[2].substring(1);
                }

                Patient patient = new Patient(data[0], data[1], data[2]);
                patients.add(patient);

                line = br.readLine();
            }

            br.close();

        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo pacientes.txt");

        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }

        return patients;
    }
}
