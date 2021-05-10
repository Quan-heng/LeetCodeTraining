package Lesson16_位运算;

public class n_queens {
    /*private static int size;
    private static int count;

    private static void solve(int row, int ld, int rd,int depth) {
        if (row == size) {
            count++;
            System.out.println("------------------" + count);
            return;
        }
        int pos = size & (~(row | ld | rd));
        while (pos != 0) {
            int p = pos & (-pos);
            System.out.println();
            pos = pos & (pos - 1);
            solve(row | p, (ld | p) << 1, (rd | p) >> 1,depth+1);
        }
    }

    public static int totalNQueens(int n) {
        count = 0;
        size = (1 << n) - 1;
        solve(0, 0, 0,0);
        return count;
    }*/

    public static int shu;
    public static int pie;
    public static int na;
    public static int count;

    public static int totalNQueens(int n) {
        dfs(0, n);
        return count;
    }

    private static void dfs(int row, int n) {
        for (int col = 0; col < n; col++) {
            int j = row + col;
            int k = n - 1 - row + col;

            if ((((shu >> col) | (pie >> j) | (na >> k)) & 1) == 1) {
                continue;
            }
            if (row == n - 1) {
                count += 1;
                System.out.println(Integer.toBinaryString(shu));
                System.out.println(Integer.toBinaryString(pie));
                System.out.println(Integer.toBinaryString(na));
                System.out.println();
                System.out.println("---------");
            } else {
                shu ^= (1 << col);
                pie ^= (1 << j);
                na ^= (1 << k);
                dfs(row + 1, n);
                shu ^= (1 << col);
                pie ^= (1 << j);
                na ^= (1 << k);
            }
        }



    }
    public static void main (String[] args){
        System.out.println( totalNQueens(4));
    }
}
