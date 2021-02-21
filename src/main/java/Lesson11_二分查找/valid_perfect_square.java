package Lesson11_二分查找;

public class valid_perfect_square {
    /**
     * 牛顿迭代法
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num){
        long r = num;
        while(r*r>num){
            r = (r+num/r)/2;
        }
        return r*r==num;

    }

    /**
     * 二分查找法
     * @param num
     * @return
     */
    public boolean isPerfectSquare1(int num) {
        if(num<=1){
            return true;
        }
        long left = 1;
        long right = num;
        long mid;
        while(left<=right){
            mid = left+(right-left)/2;
            if(mid*mid==num){
                return true;
            }else if(mid*mid<num){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return false;
    }
}
