public class MaxArea {
    public static void main(String[] args) {
      int[] input = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(method(input));
    }
    public static int method(int[] height) {
        int maxArea = 0;
        int minHeight = 0;
        for (int i = 0,j=height.length-1; i < j;) {
            minHeight = height[i]<height[j]?height[i++]:height[j--];
            maxArea = Math.max(maxArea,minHeight*(j-i+1));
        }
        return maxArea;
    }
}
