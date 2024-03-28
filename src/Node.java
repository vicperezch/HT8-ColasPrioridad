package src;

/**
 * @author Victor Pérez
 * @since 26/03/2024
 * Clase que representa un nodo del heap
 */
public class Node<V extends Comparable<V>> implements Comparable<Node<V>> {
    V value;
    Node<V> parent;
    Node<V> left;
    Node<V> right;

    /**
     * Constructor de la clase
     * @param value Valor del nodo
     */
    public Node(V value) {
        this.value = value;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    // Getters y Setters
    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node<V> getParent() {
        return parent;
    }

    public void setParent(Node<V> parent) {
        this.parent = parent;
    }

    public Node<V> getLeft() {
        return left;
    }

    public void setLeft(Node<V> left) {
        this.left = left;
    }

    public Node<V> getRight() {
        return right;
    }

    public void setRight(Node<V> right) {
        this.right = right;
    }

    /**
     * Compara dos nodos según su prioridad
     * @param other Nodo a comparar
     * @return 0 si son iguales, 1 si el nodo actual es mayor, -1 si el nodo actual es menor
     */
    @Override
    public int compareTo(Node<V> other) {
        return this.value.compareTo(other.getValue());
    }
}
