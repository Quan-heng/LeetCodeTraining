import java.util.Arrays;

/*
 * 1,2,3,4,0,0
 * 2,5
 * */
public class Test88 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = new int[]{2,5,6};
        int n = 3;
        merge(nums1, m, nums2, n);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int length1 = m-1;
        int length2 = n-1;
        int tail = m+n-1;
        while(length2>=0&&length1>=0){
            int max = nums1[length1]>nums2[length2]?nums1[length1--]:nums2[length2--];
            nums1[tail--]  = max;
        }
        if(length2>=0){
            System.arraycopy(nums2,0,nums1,0,length2+1);
        }
        System.out.println(Arrays.toString(nums1));
    }
}
