package leetcode.com;

/**
 * link: https://leetcode.com/problems/design-circular-queue/description/
 */
public class Cirular_Queue_622 {

    int head = 0;
    int tail = -1;
    int len = 0;
    int[] arr;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public Cirular_Queue_622(int k) {
        arr = new int[k];
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        tail = (tail + 1) % arr.length;
        arr[tail] = value;
        len++;

        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        head = (head + 1) % arr.length;
        len--;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return arr[head];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[tail];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return len == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return len == arr.length;
    }
}
