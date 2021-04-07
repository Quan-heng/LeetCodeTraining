package 五毒.第二周.第一遍;

import java.util.PriorityQueue;

public class zui_xiao_de_kge_shu_lcof {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr==null||k==0||arr.length<k){
            return new int[]{};
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int[] result = new int[k];
        for (int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
        }
        for(int i=0;i<4;i++){
            result[i] = queue.poll();
        }
        return result;
    }


}
