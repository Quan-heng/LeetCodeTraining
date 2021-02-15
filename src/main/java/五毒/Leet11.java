package 五毒;

/**
 * 盛水最多的容器
 * 思路：双指针法，两端逼近
 */
public class Leet11 {
    public int maxArea(int[] height) {
        if (height == null) {
            return 0;
        }
        int maxArea = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            maxArea =  height[i] < height[j] ?
                    Math.max((j - i)*height[i++],maxArea) :
                    Math.max((j - i)*height[j--], maxArea);
        }
        return maxArea;
    }
}
