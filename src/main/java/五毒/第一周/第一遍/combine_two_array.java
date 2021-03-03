package 五毒.第一周.第一遍;

import javax.print.DocFlavor;
import java.util.Arrays;

public class combine_two_array {
    public static void main(String[] args) {
        merge(new int[]{4,5,6,0,0,0}, 3, new int[]{1,2,3}, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        while (n > 0 && m > 0) {
            if (nums2[n - 1] >= nums1[m - 1]) {
                nums1[index] = nums2[--n];
                nums2[n] = 0;
            } else {
                nums1[index] = nums1[--m];
                nums1[m] = 0;
            }
            index--;
        }
        if (n > 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);//这一步很关键，把num2剩下的元素拷贝到num1的头部
        }
    }
}
