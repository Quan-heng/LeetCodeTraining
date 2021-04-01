package Lesson16_位运算;

public class power_of_two {
    /**
     * 2的幂只有一个一
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        long num = n;
        return num!=0&&(num&(num-1))==0;
    }
}
