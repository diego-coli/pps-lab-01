package tdd;

/**
 *  Task 3 - TDD for Circular Queue
 *  A simple CircularQueue that stores integers with a **fixed** capacity.
 *  When full, new elements overwrite the oldest ones.
 *  
 *  When removing elements, the oldest ones are removed first.
 *  Therefore, giving [4, 5, 3], the first element to be removed is 4, then 5, and finally 3.
 *  
 *  For the exercise: 
 *   - Think about the test cases you need to write.
 *   - Introduce methods in the interface in order to make the tests pass.
 *   - Refactor
 */
public interface CircularQueue {

    /**
     * Inserts an integer in the queue.
     * If it's full, overwrite the oldest integer.
     * @param value the integer to insert.
     */
    void enqueue(int value);

    /**
     * Remove the oldest integer from the queue.
     *
     * @throws IllegalStateException if the queue is empty.
     */
    int dequeue();

    /**
     * @return the oldest Integer of the queue.
     *
     * @throws IllegalStateException if the queue is empty.
     */
    int peek();

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Checks if the queue is full.
     *
     * @return true if the queue is full, false otherwise.
     */
    boolean isFull();

    /**
     * @return the number of Integers of the queue.
     */
    int getSize();
}