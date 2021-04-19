package dayChall202104;

class MyCircularQueue {
    private final int[] q;
    int first;
    int last;
    int maxQLen;
    int buffLen;


    public MyCircularQueue(int k) {
        this.maxQLen = k;
        this.buffLen = this.maxQLen + 1;
        this.q = new int[this.buffLen];
        this.first = 0;
        this.last = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        q[last++] = value;
        last %= buffLen;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        first++;
        first %= buffLen;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return q[first];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return q[(last + buffLen - 1) % buffLen];
    }

    public boolean isEmpty() {
        return last == first;
    }

    public boolean isFull() {
        return (last + 1) % buffLen == first;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
public class Day404_2021 {
    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        myCircularQueue.Front();    // return -1
        myCircularQueue.Rear();     // return -1
        myCircularQueue.enQueue(1); // return True
        myCircularQueue.enQueue(2); // return True
        myCircularQueue.enQueue(3); // return True
        myCircularQueue.enQueue(4); // return False
        myCircularQueue.Front();    // return 1
        myCircularQueue.Rear();     // return 3
        myCircularQueue.isFull();   // return True
        myCircularQueue.deQueue();  // return True
        myCircularQueue.enQueue(4); // return True
        myCircularQueue.Front();    // return 2
        myCircularQueue.Rear();     // return 4
    }
}
