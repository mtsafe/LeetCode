package dayChallApr2021;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyCircularQueueTest {

    MyCircularQueue myCircularQueue;

    /*
    @BeforeEach
    void setUp() {
    }
     */

    @Test
    void Example() {
        myCircularQueue = new MyCircularQueue(3);
        assertEquals(-1,myCircularQueue.Front());    // return -1
        assertEquals(-1,myCircularQueue.Rear());     // return -1
        assertTrue(myCircularQueue.enQueue(1)); // return True
        assertTrue(myCircularQueue.enQueue(2)); // return True
        assertTrue(myCircularQueue.enQueue(3)); // return True
        assertFalse(myCircularQueue.enQueue(4)); // return False
        assertEquals(1,myCircularQueue.Front());    // return 1
        assertEquals(3,myCircularQueue.Rear());     // return 3
        assertTrue(myCircularQueue.isFull());   // return True
        assertTrue(myCircularQueue.deQueue());  // return True
        assertTrue(myCircularQueue.enQueue(4)); // return True
        assertEquals(2,myCircularQueue.Front());    // return 2
        assertEquals(4,myCircularQueue.Rear());     // return 4
    }
}