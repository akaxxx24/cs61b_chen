import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

class ArrayDequeTest {

    @Test
    public static void testaddsizeempty() {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        assertEquals(true, dq.isEmpty());
        dq.addFirst(1);
        dq.addFirst(2);
        dq.addFirst(3);
        dq.addFirst(4);
        dq.addFirst(5);
        dq.addFirst(6);
        dq.addFirst(7);
        assertEquals(7 , dq.size());
        dq.addFirst(8);
        assertEquals(8 ,dq.size());
        dq.addFirst(9);
        assertEquals(9 ,dq.size());



    }

    public static void main(String[] args) {
        testaddsizeempty();
    }
}