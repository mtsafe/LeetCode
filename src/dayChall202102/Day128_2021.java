package dayChall202102;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

class FreqStack {
    ArrayList<Stack<Integer>> list;
    HashMap<Integer, Integer> hash;

    public FreqStack() {
        list = new ArrayList<>();
        hash = new HashMap<>();
    }

    public void push(int x) {
        if (hash.containsKey(x))
            hash.replace(x, hash.get(x) + 1);
        else
            hash.put(x, 1);
        int freq = hash.get(x);

        Stack<Integer> stack;
        if (list.size() < freq) {
            stack = new Stack<>();
            list.add(stack);
        } else
            stack = list.get(freq - 1);
        stack.push(x);
    }

    public int pop() {
        Stack<Integer> stack = list.get(list.size() - 1);
        int val = stack.pop();
        if (stack.size() == 0)
            list.remove(list.size() - 1);
        int freq = hash.get(val);
        if (freq == 1)
            hash.remove(val);
        else
            hash.replace(val, freq - 1);
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */

public class Day128_2021 {
    public static void main(String[] args) {
        FreqStack fS;

        System.out.println("Test Case 1:");
        fS = new FreqStack();
        fS.push(5);
        fS.push(7);
        fS.push(5);
        fS.push(7);
        fS.push(4);
        fS.push(5);
        System.out.println("5 == " + fS.pop());
        System.out.println("7 == " + fS.pop());
        System.out.println("5 == " + fS.pop());
        System.out.println("4 == " + fS.pop());

        System.out.println("Test Case 2:");
        fS = new FreqStack();
        fS.push(1);
        fS.push(1);
        fS.push(1);
        fS.push(2);
        System.out.println("1 == " + fS.pop());
        System.out.println("1 == " + fS.pop());
        fS.push(2);
        fS.push(2);
        fS.push(1);
        System.out.println("2 == " + fS.pop());
        System.out.println("1 == " + fS.pop());
        System.out.println("2 == " + fS.pop());
    }
}
