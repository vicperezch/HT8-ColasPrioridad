package src;

public interface IPriorityQueue<E> {
    /**
     * Añade un elemento a la cola de prioridad
     * @param element Elemento a añadir
     */
    void add(E element);

    /**
     * Elimina el elemento con mayor prioridad de la cola
     * @return Elemento eliminado
     */
    E remove();

    /**
     * Devuelve el tamaño de la cola
     * @return Tamaño de la cola
     */
    int size();

    /**
     * Verifica si la cola está vacía
     * @return true si está vacía, false si no
     */
    boolean isEmpty();
}