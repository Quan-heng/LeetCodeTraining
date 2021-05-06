package 五毒.第八周.第一遍;

public class reverse_bits {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int t = n >> i & 1;
            if (t == 1) {
                result |= 1 << (31 - i);
            }
        }
        return result;
    }
}
