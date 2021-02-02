import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test350 {
    public static void main(String[] args) {
      int[] nums1 = new int[]{2,1,2,1};
      int[] nums2 = new int[]{2,2};
        System.out.println(Arrays.toString(intersect(nums1,nums2)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<Integer>();
        if(nums1==null||nums2==null){
            return new int[]{};
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1=0;
        int index2=0;
        while(index1<nums1.length&&index2<nums2.length){
            if(nums1[index1]<nums2[index2]){
                index1++;
            }else if(nums1[index1]==nums2[index2]){
                list.add(nums1[index1]);
                index1++;
                index2++;
            }else{
                index2++;
            }
        }
        if(list.isEmpty()){
            return new int[]{};
        }else{
            int[] result = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                result[i] = list.get(i);
            }
            return result;
        }
    }
}
