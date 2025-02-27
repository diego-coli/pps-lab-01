package tdd;

public class SimpleCircularQueue implements CircularQueue{

    private final Integer[] circularQueue;
    private final static int MAX_SIZE = 5;
    private int size;
    private int first;
    private int last;

    public SimpleCircularQueue() {
        this.circularQueue = new Integer[MAX_SIZE];
        this.size = 0;
        this.first = 0;
        this.last = -1;
    }

    @Override
    public boolean isEmpty(){
        if(this.size == 0){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean isFull(){
        if(this.size == MAX_SIZE){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void enqueue(int value) {
        if (isFull()) {
            this.first = (this.first + 1) % MAX_SIZE;
        } else {
            this.size++;
        }
        this.last = (this.last + 1) % MAX_SIZE;
        circularQueue[this.last] = value;
    }

    @Override
    public int dequeue() {
        int output;
        if (isEmpty()) {
            throw new IllegalStateException("\nERR: Queue is already empty!");
        }
        else{
            output = circularQueue[this.first];
            circularQueue[this.first] = null;
            this.first = (this.first + 1) % MAX_SIZE;
            this.size--;
            return output;
        }
    }

    @Override
    public int peek(){
        if(isEmpty()){
            throw new IllegalStateException("\nERR: Queue is empty!");
        }
        else{
            return circularQueue[first];
        }
    }

    @Override
    public int getSize(){
        return this.size;
    }


}


