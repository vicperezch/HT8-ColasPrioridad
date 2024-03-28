package src;

/**
 * @author Victor Pérez
 * @since 24/03/2024
 * Clase principal donde se ejecuta el programa
 */
public class Main {
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>();
        heap.add(5);
        heap.add(3);
        heap.add(7);
        heap.add(1);
        heap.add(3);
        heap.add(7);
        heap.add(1);

        for (int i = 0; i < 7; i++) {
            int a = heap.remove();
            System.out.println(a);
        }
    }
}