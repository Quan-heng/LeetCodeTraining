package Lesson11_二分查找;

/**
 * x的平方根
 */
public class Test69 {
    public static void main(String[] args) {
        System.out.println(mySqrt(4));
    }

    /**
     * 牛顿迭代法
     * @param x
     * @return
     */
    public static int mySqrt(int x){
        long r = x;
        while(r*r>x){
            r = (r+x/r)/2;
        }
        return (int) r;
    }

    /**
     * 二分查找法
     * @param x
     * @return
     */
    public static int mySqrt1(int x) {
        if (x == 1||x==0) {
            return x;
        }
        long left = 1;
        long right = x;
        long mid=1;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (mid * mid > x) {
                right = mid-1;
            } else {
               left=mid+1;
            }

        }
        return (int) right;
    }
}
