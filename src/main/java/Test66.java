import java.util.Arrays;

//加1
public class Test66 {
    public static void main(String[] args) {
       int[] nums = new int[]{0,0};
        System.out.println(Arrays.toString(plusOne(nums)));
    }

    public static int[] plusOne(int[] digits) {
        if (digits == null) {
            return null;
        }
        int i = digits.length - 1;
        while (i >= 0) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            } else {
                digits[i--] = 0;
                continue;
            }
        }
        if (digits[0] == 0) {
            int[] newArray = new int[digits.length + 1];
            System.arraycopy(digits, 0, newArray, 1, digits.length);
            newArray[0] = 1;
            return newArray;
        } else {
            return digits;
        }
    }
}
