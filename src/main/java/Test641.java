public class Test641 {
    public static void main(String[] args) {
        MyCircularDeque deque = new MyCircularDeque(77);
        deque.insertFront(89);
        int rear = deque.getRear();
        deque.deleteLast();
        rear = deque.getRear();
        deque.insertFront(19);
        deque.insertFront(19);
        deque.insertFront(23);
        deque.insertFront(23);
        deque.isFull();
        deque.insertFront(82);
        deque.isFull();
        int error = deque.getRear();
        //deque.deleteLast();
       // int rear = deque.getRear();

        int value =  deque.getRear();
    }
}
