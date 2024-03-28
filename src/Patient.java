package src;

/**
 * @author Victor Pérez
 * @since 28/03/2024
 * Clase que modela un paciente del hospital
 */
public class Patient implements Comparable<Patient> {
    private String name;
    private String motive;
    private String priority;


    /**
     * Constructor de la clase
     * @param name Nombre del paciente
     * @param motive Motivo de la visita
     * @param priority Prioridad del paciente
     */
    public Patient(String name, String motive, String priority) {
        this.name = name;
        this.motive = motive;
        this.priority = priority;
    }


    /**
     * Compara dos pacientes según su prioridad
     * @param other Paciente a comparar
     * @return 0 si son iguales, -1 si el paciente actual tiene mayor prioridad, 1 si el otro paciente tiene mayor prioridad
     */
    @Override
    public int compareTo(Patient o) {
        return this.priority.compareTo(o.getPriority());
    }


    // Getters y Setters
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getMotive() {
        return motive;
    }


    public void setMotive(String motive) {
        this.motive = motive;
    }


    public String getPriority() {
        return priority;
    }


    public void setPriority(String priority) {
        this.priority = priority;
    }
}
