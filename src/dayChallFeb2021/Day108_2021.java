package dayChallFeb2021;

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class SolutionDay108 {
    class PeekingIterator implements Iterator<Integer> {
        private Iterator<Integer> itr;
        private Queue<Integer> q;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.itr = iterator;
            q = new LinkedList<>();
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            if (q.size() == 0 && itr.hasNext()) {
                q.add(itr.next());
            }
            return q.peek();
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if (q.size() == 0 && itr.hasNext()) {
                q.add(itr.next());
            }
            return q.poll();
        }

        @Override
        public boolean hasNext() {
            if (q.size() == 0 && itr.hasNext()) {
                q.add(itr.next());
            }
            return q.size() != 0;
        }
    }
}

public class Day108_2021 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        // Example:
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> itr = list.listIterator();
        SolutionDay108 solution = new SolutionDay108();
        SolutionDay108.PeekingIterator pI = solution.new PeekingIterator(itr);
        System.out.println("1 == "+pI.next());
        System.out.println("2 == "+pI.peek());
        System.out.println("2 == "+pI.next());
        System.out.println("3 == "+pI.next());
        System.out.println("false == "+pI.hasNext());
    }
}
