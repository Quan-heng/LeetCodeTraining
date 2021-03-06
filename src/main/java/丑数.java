import java.util.PriorityQueue;

public class 丑数 {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(7));
    }

    public static int nthUglyNumber(int n) {
        long result = 1;
        int i = 1;
        PriorityQueue<Long> heap = new PriorityQueue<>();
        heap.add(result);
        while (i <= n) {
            result = heap.poll();
            while (!heap.isEmpty() && heap.peek() == result) {
                heap.poll();
            }
            heap.add(result * 2);
            heap.add(result * 3);
            heap.add(result * 5);
            i++;
        }
        return (int)result;
    }
}
