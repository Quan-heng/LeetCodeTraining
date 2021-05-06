package 五毒.第八周.第一遍;

public class number_of_1_bits {
    public int hammingWeight(int n) {
        int count = 0;
        while(n!=0){
            n = n&(n-1);
            count++;
        }
        return count;
    }
}
