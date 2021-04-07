package 五毒.第一周.第二遍;

public class merge_sorted_array {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int index = m + n - 1;

        while (i >= 0 && j >= 0 ) {
            if (nums2[j] > nums1[i]) {
                nums1[index] = nums2[j--];
            } else {
                nums1[index] = nums1[i--];
            }
            index--;
        }
        if (j >= 0) {
            System.arraycopy(nums2, 0, nums1, i + 1, j + 1);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};
        merge(nums1, 0, nums2, 1);
    }
}
