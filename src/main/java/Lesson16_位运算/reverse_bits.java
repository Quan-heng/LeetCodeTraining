package Lesson16_位运算;

public class reverse_bits {
    public int reverseBits(int n){
        int res = 0;
        for(int i=0;i<32;i++){
            res = 1<<res;
            res= res|(n&1);
            n=n>>1;
        }
        return res;
    }

    public static void main(String[] args) {
        String str = Integer.toBinaryString(0<<1);
        System.out.println(str);
    }
}
