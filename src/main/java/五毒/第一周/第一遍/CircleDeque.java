package 五毒.第一周.第一遍;

class MyCircularDeque {
    private int[] queue;
    private int head;
    private int tail;
    private int size = 0;

    public MyCircularDeque(int k) {
        size = k+1;
        queue = new int[k + 1];
        head = 0;
        tail = 0;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        head = moveLeft(head);
        queue[head] = value;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        queue[tail] = value;
        tail = moveRight(tail);
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        head = moveRight(head);
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        tail = moveLeft(tail);
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if(isEmpty()){
            return -1;
        }
        return queue[head];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if(isEmpty()){
            return -1;
        }
        return queue[moveLeft(tail)];
    }

    /**
     *
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return head == tail;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
         return moveRight(tail)==head;
    }

    private int moveLeft(int n) {
        return n - 1 < 0 ? n - 1 + size : n - 1;
    }
    private int moveRight(int n){
        return n + 1 >= size ? n + 1 - size : n + 1;
    }
}
