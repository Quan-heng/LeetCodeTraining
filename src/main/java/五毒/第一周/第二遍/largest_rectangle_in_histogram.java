package 五毒.第一周.第二遍;

import java.util.Deque;
import java.util.LinkedList;

public class largest_rectangle_in_histogram {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i <= heights.length; i++) {
            int temp = i == heights.length ? -1 : heights[i];
            while (stack.peek() != -1 && temp <= heights[stack.peek()]) {
                int index = stack.pop();
                maxArea = Math.max(maxArea, heights[index] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        return maxArea;
    }
}
