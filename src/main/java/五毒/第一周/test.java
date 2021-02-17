package 五毒.第一周;

public class test {
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(2);
        stack.push(0);
        stack.push(3);
        stack.push(0);
        System.out.println(stack.getMin());
        stack.pop();

        System.out.println(stack.getMin());
        stack.pop();

        System.out.println(stack.getMin());
        stack.pop();

        System.out.println(stack.getMin());


    }
}
