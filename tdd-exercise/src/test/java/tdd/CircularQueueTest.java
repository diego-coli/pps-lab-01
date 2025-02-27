package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularQueue implementation
 */
public class CircularQueueTest {

    private SimpleCircularQueue circularQueue;
    private static final int VALUE = 1;

    @BeforeEach
    void initCircularQueue(){
        circularQueue = new SimpleCircularQueue();
    }

    @Test
    void isInitiallyEmpty(){
        assertTrue(circularQueue.isEmpty());
    }

    @Test
    void tryToEnqueue(){
        circularQueue.enqueue(VALUE);
        assertFalse(circularQueue.isEmpty());
    }

    @Test
    void tryToMultipleEnqueue(){
        for(int i = 0; i < 3; i++){
            circularQueue.enqueue(VALUE);
        }
        assertFalse(circularQueue.isEmpty());
    }

    @Test
    void tryToFill(){
        for(int i = 0; i < 5; i++){
            circularQueue.enqueue(VALUE);
        }
        assertTrue(circularQueue.isFull());
    }

    @Test
    void tryToDequeue(){
        circularQueue.enqueue(VALUE);
        circularQueue.dequeue();
        assertTrue(circularQueue.isEmpty());
    }

    @Test
    void tryToDequeueEmptyQueue(){
        assertThrows(IllegalStateException.class, circularQueue::dequeue);
    }

    @Test
    void tryToGetSizeEmptyQueue(){
        assertEquals(0, circularQueue.getSize());
    }

    @Test
    void tryToGetSizeFullQueue(){
        for(int i = 0; i < 5; i++) {
            circularQueue.enqueue(VALUE);
        }
        assertEquals(5, circularQueue.getSize());
    }

    @Test
    void tryToPeek(){
        circularQueue.enqueue(45);
        circularQueue.enqueue(21);
        circularQueue.enqueue(7);
        assertEquals(45, circularQueue.peek());
    }

    @Test
    void tryToPeekAfterMultipleEnqueue(){
        for(int i = 0; i < 6; i++){
            circularQueue.enqueue(i);
        }
        assertEquals(1, circularQueue.peek());
    }
}
