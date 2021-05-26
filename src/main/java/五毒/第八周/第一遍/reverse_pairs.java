package 五毒.第八周.第一遍;

import java.util.Arrays;

public class reverse_pairs {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int start, int end) {
        if(end<=start){
            return 0;
        }
        int mid = (start + end) / 2;
        int cnt = mergeSort(nums, start, mid) + mergeSort(nums, mid + 1, end);
        for (int i = start, j = mid + 1; i <= mid; i++) {
            while (j <= end && nums[i]/2.0 >  nums[j]) {
                cnt++;
                j++;
            }
        }
        Arrays.sort(nums, start, end+1);
        return cnt;
    }
}
