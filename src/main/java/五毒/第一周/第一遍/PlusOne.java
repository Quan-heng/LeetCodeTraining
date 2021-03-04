package 五毒.第一周.第一遍;

import java.util.Arrays;
import java.util.Collections;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int index = digits.length-1;
        while(index>=0){
            if(digits[index]==9){
                digits[index]=0;
            }else{
                digits[index] = digits[index]+1;
                break;
            }
            index--;
        }
        if(index==-1){
            int[] newArray = new int[digits.length+1];
            newArray[0]=1;
            System.arraycopy(digits,0,newArray,1,digits.length);
            return newArray;
        }
        return digits;
    }
}
