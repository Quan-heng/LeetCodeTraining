package 五毒.第四周.第一遍;

public class valid_perfect_square {
    public static boolean isPerfectSquare(int num) {
         long r = num;
         while(r*r>num){
             r = (r+num/r)/2;
         }
         return r*r==num;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(9));
    }
}
