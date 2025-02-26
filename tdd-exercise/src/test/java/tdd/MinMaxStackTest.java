package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackTest {

    private SimpleMinMaxStack stack;
    private static final int VALUE = 1;

    @BeforeEach
    void initStack(){
        stack = new SimpleMinMaxStack();
    }

    @Test
    void isInitiallyEmpty(){
        assertTrue(stack.isEmpty());
    }

    @Test
    void tryToPush(){
        stack.push(VALUE);
        assertFalse(stack.isEmpty());
    }

    @Test
    void tryToMultiplePushAndGetSize(){
        for(int i = 1; i < 5; i++){
            stack.push(VALUE);
        }
        assertEquals(4, stack.size());
    }

    @Test
    void tryToPop(){
        stack.push(VALUE);
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    void tryToPopEmptyStack(){
        assertThrows(IllegalStateException.class, stack::pop);
    }

    @Test
    void tryToPeek(){
        stack.push(VALUE);
        assertEquals(VALUE, stack.peek());
    }

    @Test
    void tryToPeekEmptyStack(){
        assertThrows(IllegalStateException.class, stack::peek);
    }

    @Test
    void tryToGetMin(){
        for(int i = 1; i < 5; i++){
            stack.push(i);
        }
        assertEquals(1, stack.getMin());
    }

    @Test
    void tryToGetMinEmptyStack(){
        assertThrows(IllegalStateException.class, stack::getMin);
    }

    @Test
    void tryToGetMax(){
        for(int i = 1; i < 5; i++){
            stack.push(i);
        }
        assertEquals(4, stack.getMax());
    }

    @Test
    void tryToGetMaxEmptyStack(){
        assertThrows(IllegalStateException.class, stack::getMax);
    }
}