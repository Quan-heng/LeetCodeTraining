public class Pow50 {
    public static void main(String[] args) {
        System.out.println(myPow(0, -1));
    }

    public static double myPow(double x, int n) {
        double half = 0;
        double rest = 0;
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if (n == -1) {
            return 1 / x;
        }
        half = myPow(x,n/2);
        rest =  myPow(x,n%2);
        return half*half*rest;
    }
}

