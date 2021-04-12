package 五毒.第一周.第一遍;

import java.util.Stack;

public class trapping_rain_water {
    /**
     * stack 解法
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int area = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int top = stack.pop();
                if (!stack.isEmpty()) {
                    int pre = stack.peek();
                    int w = i - pre - 1;
                    area += (Math.min(height[i], height[pre]) - height[top]) * w;
                }
            }
            stack.push(i);
        }
        return area;
    }

    /**
     * 双指针解法
     *
     * @param height
     * @return
     */
    public int trap1(int[] height) {
        int left = 0, leftMax = 0, right = height.length - 1, rightMax = 0;
        int area = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(height[left], leftMax);
                area += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(height[right], rightMax);
                area += rightMax - height[right];
                right++;
            }
        }
        return area;

    }
}
