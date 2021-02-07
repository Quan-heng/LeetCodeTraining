import java.util.ArrayDeque;
import java.util.Deque;

public class 柱形图最大的面积84 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 2, 0};
        System.out.println(largestRectangleArea(nums));
    }

    /**
     * Stack
     *
     * @param heights
     * @return
     */
    public static int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        if (heights == null) {
            return 0;
        }
        stack.push(-1); //-1用来辅助计算边界长度
        int[] newArr = new int[heights.length + 1]; //假设数组的最后有一个0高度的元素，将原数组拷贝到新数组，末位加0，防止到最后没有找到右边界,确保所有元素都能出栈。
        System.arraycopy(heights, 0, newArr, 0, heights.length);
        newArr[heights.length] = 0;
        int maxArea = 0;
        int temp;
        for (int i = 0; i < newArr.length; i++) {
            //if (stack.peek() != -1 && newArr[i] > newArr[stack.peek()]) {//如果高度比前一个大，压入栈
             //   stack.push(i);
           // } else { //比前一个高度低，计算左边的值
                while (stack.peek() != -1 && newArr[i] <= newArr[stack.peek()]) {
                    temp = stack.pop();
                    maxArea = Math.max(newArr[temp] * (i - stack.peek() - 1), maxArea); //i减去上上个元素的下标-1
                }
                stack.push(i);
            //}
        }
        return maxArea;
    }
}
