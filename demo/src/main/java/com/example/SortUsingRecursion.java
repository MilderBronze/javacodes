package com.example;

import java.util.*;
import java.io.*;

public class SortUsingRecursion {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // push elements from bottom to top
        stack.push(1);
        stack.push(11);
        stack.push(8);
        stack.push(94);
        stack.push(49);
        stack.push(67);
        stack.push(74);
        stack.push(83);
        deleteMiddle(stack, stack.size() - 1);
        printStack(stack);
    }

    public static void printStack(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();

        // Copy the original stack into a temp stack
        temp.addAll(stack);

        System.out.println("Stack from Top to Bottom:");
        while (!temp.isEmpty()) {
            System.out.println(temp.pop());
        }
    }

    public static void deleteMiddle(Stack<Integer> inputStack, int N) {
        if (inputStack.empty()) {
            return;
        }
        // WRITE YOUR CODE HERE
        helper(inputStack, 1, N);
    }

    public static void helper(Stack<Integer> inputStack, int c, int N) {

        if (c == (N / 2) + 1) {
            int ele = inputStack.pop();
            return;
        }
        int top = inputStack.pop();
        helper(inputStack, c + 1, N);
        inputStack.push(top);
    }
}
