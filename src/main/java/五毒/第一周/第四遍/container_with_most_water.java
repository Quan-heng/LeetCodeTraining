package 五毒.第一周.第四遍;

public class container_with_most_water {
    public static void main(String[] args){
        int[] height = new int[]{4,3,2,1,4};
        System.out.println(maxArea(height));
    }

    public static  int maxArea(int[] height){
        int i = 0;
        int j= height.length-1;
        int max = Integer.MIN_VALUE;
        while(i<j){
           int temp =  (j-i)*Math.min(height[i],height[j]);
           if(temp>max){
               max = temp;
           }
           if(height[i]<height[j]){
               i++;
           }else{
               j--;
           }
        }
        return max;
    }

}
