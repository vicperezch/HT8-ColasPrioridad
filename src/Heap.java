package src;

/**
 * @author Victor Pérez
 * @since 27/03/2024
 * Clase que representa una cola de prioridad
 */
public class Heap<E extends Comparable<E>> implements IPriorityQueue<E> {
    Node<E> root;
    int size;


    /**
     * Constructor de la clase
     */
    public Heap() {
        this.root = null;
        this.size = 0;
    }


    /**
     * Agrega un elemento nuevo al heap respetando la forma invariante
     * @param value Valor a agregar
     */
    public void add(E value) {
        this.size++;

        if (this.root == null) {
            this.root = new Node<>(value);

        } else {
            Node<E> temp = new Node<>(value);

            // Recorre el camino hasta la posición donde se debe agregar el nuevo nodo
            Node<E> last = findLastNode();
            if (last.getLeft() == null) {
                last.setLeft(temp);

            } else {
                last.setRight(temp);
            }

            temp.setParent(last);

            // Respeta el orden invariante del heap
            evaluateBottomInvariantOrder(temp);
        }
    }


    /**
     * Elimina el nodo con mayor prioridad del heap
     * @return Valor del nodo eliminado
     */
    public E remove() {
        if (this.size == 0) {
            return null;
        }

        E topValue = root.getValue();

        if (this.size == 1) {
            this.root = null;
        
        } else {
            // Intercambia la raíz con el último nodo
            Node<E> last = findLastNode();
            swap(root, last);

            // Elimina el último nodo
            if (last.getParent().getRight() == null) {
                last.getParent().setLeft(null);

            } else {
                last.getParent().setRight(null);
            }

            evaluateTopInvariantOrder(this.root);
        }
        
        this.size--;

        return topValue;
    }


    /**
     * Devuelve el tamaño del heap
     * @return Tamaño del heap
     */
    public int size() {
        return this.size;
    }


    /**
     * Verifica si el heap está vacío
     * @return true si está vacío, false si no
     */
    public boolean isEmpty() {
        return this.size == 0;
    }


    /**
     * Encuenta la última posición según la forma invariante del heap
     * @return Nodo en la última posición
     */
    private Node<E> findLastNode() {
        String[] path = Integer.toBinaryString(this.size).substring(1).split("");

        Node<E> current = this.root;
        for (int i = 0; i < path.length; i++) {
            if (path[i].equals("0")) {
                if (current.getLeft() != null) {
                    current = current.getLeft();
                }

            } else {
                if (current.getRight() != null) {
                    current = current.getRight();
                }
            }
        }

        return current;
    }


    /**
     * Evalúa el orden invariante y cambia los nodos empezando desde una hoja hasta la raíz
     * @param current Nodo actual
     */
    private void evaluateBottomInvariantOrder(Node<E> current) {
        if (current.getParent() != null) {
            if (current.getParent().compareTo(current) > 0) {
                swap(current.getParent(), current);
                evaluateBottomInvariantOrder(current.getParent());
            }
        }  
    }


    /**
     * Evalúa el orden invariante y cambia los nodos empezando desde la raíz hasta una hoja
     * @param current Nodo actual
     */
    private void evaluateTopInvariantOrder(Node<E> current) {
        if (current.getRight() != null) {
            if (current.getLeft().compareTo(current) < 0) {
                if (current.getRight().compareTo(current) < 0) {
                    if (current.getLeft().compareTo(current.getRight()) < 0) {
                        swap(current, current.getLeft());
                        evaluateTopInvariantOrder(current.getLeft());

                    } else {
                        swap(current, current.getRight());
                        evaluateTopInvariantOrder(current.getRight());
                    }

                } else {
                    swap(current, current.getLeft());
                    evaluateTopInvariantOrder(current.getLeft());
                }

            } else {
                if (current.getRight().compareTo(current) < 0) {
                    swap(current, current.getRight());
                    evaluateTopInvariantOrder(current.getRight());
                } 
            }

        } else if (current.getLeft() != null) {
            if (current.getLeft().compareTo(current) < 0) {
                swap(current, current.getLeft());
                evaluateTopInvariantOrder(current.getLeft());
            }
        }
    }


    /**
     * Intercambia los valores de dos nodos
     * @param a Primer nodo a intercambiar
     * @param b Segundo nodo a intercambiar
     */
    private void swap(Node<E> a, Node<E> b) {
        E tempValue = a.getValue();
        a.setValue(b.getValue());
        b.setValue(tempValue);
    }
}
