package 每日一题;

public class valid_perfect_square {
    public boolean isPerfectSquare(int num) {
        long left = 1;
        long right = num / 2 + 1;
        long mid = 1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;

    }
}

