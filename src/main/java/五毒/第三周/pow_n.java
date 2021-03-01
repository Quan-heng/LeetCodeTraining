package 五毒.第三周;

/**
 * 分治
 */
public class pow_n {
    public static void main(String[] args) {
        System.out.println(myPow(2, -2));
    }

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if (n == -1) {
            return 1 / x;
        } else {
            double half = myPow(x, n / 2);
            return half * half * myPow(x, n % 2);
        }
    }
}
