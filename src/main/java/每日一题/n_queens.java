package 每日一题;



import java.util.*;

/**
 * 思路：回溯
 * board[][] ,shu, pie, na
 */
public class n_queens {
    public static char[][] board;
    public static  Set<Integer> shu = new HashSet<>();
    public static Set<Integer> pie = new HashSet<>();
    public static Set<Integer> la = new HashSet<>();

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
    public  static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        int depth = 0;
        dfs(result,board,depth,n);
        return result;
    }

    private static void dfs(List<List<String>> result, char[][] board, int depth,int n) {
        if(depth==n){
            StringBuilder sb = new StringBuilder();
            List<String> list = new ArrayList<>();
            for(int i=0;i<n;i++){
                sb = new StringBuilder();
                for(int j=0;j<n;j++){
                    sb.append(board[i][j]);
                }
                list.add(sb.toString());
            }
            result.add(list);
            return;
        }
        for(int i=0;i<n;i++){
            if(shu.contains(i)||pie.contains(depth+i)||la.contains(depth-i)){
                continue;
            }
            shu.add(i);
            pie.add(depth+i);
            la.add(depth-i);
            board[depth][i]='Q';
            dfs(result,board,depth+1,n);
            shu.remove(i);
            pie.remove(depth+i);
            la.remove(depth-i);
            board[depth][i]='.';
        }
    }
}
