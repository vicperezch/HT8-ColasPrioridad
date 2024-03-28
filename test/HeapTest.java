package test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import src.Heap;

/**
 * @author Victor Pérez
 * @since 27/03/2024
 * Clase de pruebas para Heap
 */
public class HeapTest {

    /**
     * Test 1: Añadir elementos al heap
     */
    @Test
    public void testAdd() {
        Heap<Integer> heap = new Heap<>();
        heap.add(5);
        heap.add(3);
        heap.add(7);
        heap.add(1);
        heap.add(4);
        heap.add(6);
        heap.add(8);
        heap.add(2);
        heap.add(9);
        heap.add(0);
        assertEquals(10, heap.size());
    }


    /**
     * Test 2: Eliminar elementos del heap
     */
    @Test
    public void testRemove() {
        Heap<Integer> heap = new Heap<>();
        heap.add(5);
        heap.add(3);
        heap.add(7);
        heap.add(1);
        heap.add(4);
        heap.add(6);
        heap.add(8);
        heap.add(2);
        heap.add(9);
        heap.add(0);

        for (int i = 0; i < 10; i++) {
            int a = heap.remove();
            assertEquals(i, a);
        }
    }


    /**
     * Test 3: Añadir elementos repetidos al heap
     */
    @Test
    public void testAddRepeated() {
        Heap<Integer> heap = new Heap<>();
        heap.add(5);
        heap.add(3);
        heap.add(7);
        heap.add(1);
        heap.add(3);
        heap.add(7);
        heap.add(1);

        assertEquals(7, heap.size());
    }


    /**
     * Test 4: Eliminar elementos repetidos del heap
     */
    @Test
    public void testRemoveRepeated() {
        Heap<Integer> heap = new Heap<>();
        heap.add(5);
        heap.add(3);
        heap.add(7);
        heap.add(1);
        heap.add(3);
        heap.add(7);
        heap.add(1);

        assertEquals(1, (int) heap.remove());
        assertEquals(1, (int) heap.remove());
        assertEquals(3, (int) heap.remove());
        assertEquals(3, (int) heap.remove());
        assertEquals(5, (int) heap.remove());
        assertEquals(7, (int) heap.remove());
        assertEquals(7, (int) heap.remove());
    }


    /**
     * Test 5: Eliminar elementos de un heap vacío
     */
    @Test
    public void testRemoveEmpty() {
        Heap<Integer> heap = new Heap<>();
        assertEquals(null, heap.remove());
    }
}
