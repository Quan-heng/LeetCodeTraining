package Lesson18_排序算法;

import java.util.Arrays;

public class quick_sort {
    public static void quickSort(int[] array,int begin,int end){
        if(end<=begin) return;
        int pivot = partition(array,begin,end);
        quickSort(array,begin,pivot-1);
        quickSort(array,pivot+1,end);
    }

    static int partition(int[] a,int begin, int end){
        int pivot = end,counter = begin;
        for(int i=begin;i<end;i++){
            if(a[i]<a[pivot]){
                int temp = a[counter];
                a[counter] = a[i];
                a[i] = temp;
                counter++;
            }
        }
        int temp = a[pivot];
        a[pivot] = a[counter];
        a[counter] = temp;
        return counter;
    }

    public static void main(String[] args) {
        int[] array = new int[]{9,2,4,1,8,6,7};
        quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
