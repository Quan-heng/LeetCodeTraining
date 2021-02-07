import java.util.ArrayList;
import java.util.List;

public class 各位相加258 {
    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }

    public static int addDigits(int num) {
        //1.递归法
        /*int sum = 0;
        if(num<=9){
            return num;
        }
        while(num!=0){
            sum+= num%10;
            num/=10;
        }
        return addDigits(sum);*/
        //2.数学解法
        return (num - 1) % 9 + 1;
    }
}
