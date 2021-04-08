package 五毒.第三周.第二遍;

public class powx_n {
    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == -1) {
            return 1 / x;
        }
        if (n == 1) {
            return x;
        }
        double half = myPow(x, n / 2);
        return half * half * myPow(x, n % 2);
    }

    public static void main(String[] args) {
        System.out.println(myPow(2, 10));
    }
}
