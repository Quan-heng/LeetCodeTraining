package Lesson18_排序算法.第一遍;

import java.util.Arrays;
import java.util.List;

public class merge_sort {
    public static void mergeSort(int[] a, int begin, int end) {
        if (begin >= end) return;
        int mid = (begin + end) >> 1;
        mergeSort(a, begin, mid);
        mergeSort(a, mid + 1, end);
        merge(a, begin, mid, end);
    }

    private static void merge(int[] a, int begin, int mid, int end) {
        int[] temp = new int[end - begin + 1];
        int k = 0;
        int i = begin;
        int j = mid + 1;
        while (i <= mid && j <= end) {
            temp[k++]= a[i]<a[j]?a[i++]:a[j++];
        }
        while(i<=mid){
            temp[k++] = a[i++];
        }
        while(j<=end){
            temp[k++] = a[j++];
        }
        for(int n=0;n<temp.length;n++){
            a[begin+n] = temp[n];
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{4,1,6,2,7,8,13};
        mergeSort(array,0,array.length-1);
        System.out.println("haha");
        //List<Integer> list = Arrays.asList(array);
    }

}
