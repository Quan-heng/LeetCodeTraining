package 五毒.第一周.第一遍;

public class test {
    public static void main(String[] args) {
        MyCircularDeque queue = new MyCircularDeque(3);
        queue.insertFront(4);;
        queue.deleteLast();
        System.out.println(queue.getRear());
    }


}
