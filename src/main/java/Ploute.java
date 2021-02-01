public class Ploute {
    public static void main(String[] args) {
        System.out.println(method(-1));
    }
    private static int method(int n){
        if(n<=2){
            return n;
        }
        int[] a = new int[n+1];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        for(int i=3;i<n+1;i++){
            a[i] = a[i-1]+a[i-2];
        }
        return a[n];
    }
}
