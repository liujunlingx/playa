package com.company.algorithm.collections;

import java.util.Stack;

public class TwoStackAsQueue {
    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<Integer> stack2 = new Stack<Integer>();

    private void add(int node) {
        stack1.push(node);
    }

    private int remove() {
        if(stack1.empty() && stack2.empty()){
            throw new RuntimeException("cannot pop from empty queue");
        }
        while (stack1.size() != 1){
            stack2.push(stack1.pop());
        }
        int result = stack1.pop();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return result;
    }

    public static void main(String[] args) {
        TwoStackAsQueue queue = new TwoStackAsQueue();
        for (int i = 0; i < 5; i++) {
            queue.add(i);
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(queue.remove());
        }
    }

}
