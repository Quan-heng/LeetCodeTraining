package Lesson16_位运算;

import javafx.util.converter.ByteStringConverter;

import java.security.spec.RSAOtherPrimeInfo;

public class n_queens {
    private static int size;
    private static int count;

    private static void solve(int row, int ld, int rd) {
        if (row == size) {
            count++;
            System.out.println("--------");
            return;
        }

        int pos = size & (~(row | ld | rd));
        
        while (pos != 0) {
            int p = pos & (-pos);
            pos &= pos - 1;
            solve(row | p, (ld | p) << 1, (rd | p) >> 1);
        }
    }

    public static int totalNQueens(int n) {
        count = 0;
        size = (1 << n) - 1;
        solve(0, 0, 0);
        return count;


    }

    public static void main (String[]args){
        System.out.println(totalNQueens(4));
    }
}
