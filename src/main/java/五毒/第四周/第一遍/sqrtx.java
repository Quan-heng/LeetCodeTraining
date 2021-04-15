package 五毒.第四周.第一遍;

public class sqrtx {

    public static int mySqrt(int x){
        long a = x;
        while(a*a>x){
            a = (a+x/a)/2;
        }
        return (int)a;
    }
    /**
     * 二分查找法
     * @param x
     * @return
     */
    public int mySqrt2(int x) {
        long left = 1;
        long right = x/2;
        long mid;
        while(left<=right){
            mid = left+(right-left)/2;
            if(mid*mid>x){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return (int)right;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(3));
    }
}
