package tdd;

import java.util.EmptyStackException;
import java.util.Stack;

public class SimpleMinMaxStack implements MinMaxStack{

    private final Stack<Integer> stack;
    private int min;
    private int max;

    public SimpleMinMaxStack(){
        this.stack = new Stack<>();
    }

    @Override
    public void push(int value){
        stack.push(value);
    }

    @Override
    public int pop(){
        if(!stack.isEmpty()){
            return stack.pop();
        }
        else{
            throw new IllegalStateException("\nERR: Stack is already empty!");
        }
    }

    @Override
    public int peek(){
        if(!stack.isEmpty()){
            return stack.peek();
        }
        else{
            throw new IllegalStateException("\nERR: Stack is empty!");
        }
    }

    @Override
    public int getMin(){
        if(!stack.isEmpty()){
            min = stack.peek();
            for(Integer element : stack){
                if(element < min){
                    min = element;
                }
            }
            return min;
        }
        else{
            throw new IllegalStateException("\nERR: Stack is empty!");
        }
    }

    @Override
    public int getMax(){
        if(!stack.isEmpty()){
            max = stack.peek();
            for(Integer element : stack){
                if(element > max){
                    max = element;
                }
            }
            return max;
        }
        else{
            throw new IllegalStateException("\nERR: Stack is empty!");
        }
    }

    @Override
    public boolean isEmpty(){
        if(stack.empty()){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public int size(){
        return stack.size();
    }
}
