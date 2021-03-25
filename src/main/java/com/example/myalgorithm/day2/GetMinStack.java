package com.example.myalgorithm.day2;

import java.util.Stack;

public class GetMinStack {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public GetMinStack(){
        dataStack = new Stack<>();
        minStack = new Stack<>();

    }

    public int push(int obj){
        if(dataStack.isEmpty()){
            minStack.push(obj);
        }else if(obj<minStack.peek()){

            minStack.push(obj);
        }else {

            minStack.push(minStack.peek());
        }
        return dataStack.push(obj);
    }

    public int pop(){

        minStack.pop();
        return dataStack.pop();
    }

    public int getMin(){

        return minStack.peek();
    }

}
