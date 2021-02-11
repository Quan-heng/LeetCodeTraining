import java.util.ArrayList;
import java.util.List;

public class N皇后 {
    public static boolean[][] used;
    public static char[][] board;
    public static void main(String[] args) {
        System.out.println(solveNQueens(10));
    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if(n<=0){
            return result;
        }
        List<String> line = new ArrayList<>();
        board = new  char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        used = new boolean[n][n];
        int depth = 0;
        dfs(n,depth,result);
        return result;
    }

    private static void dfs(int n, int depth,List<List<String>> result) {
        if(n==depth){
            List<String> list = new ArrayList<>();
            for(int i=0;i<n;i++){
                list.add(new String(board[i]));
            }
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<n;i++){
            if(!used[depth][i]){
                boolean[][] temp = new boolean[n][n];
                for (int j = 0; j < used.length; j++) {
                    temp[j]=used[j].clone();
                }
                used[depth][i]=true;
                board[depth][i]='Q';
                //计算将其能杀死的所有空格,八个方向
                //1.向右
                for(int j=i+1;j<n;j++){
                    used[depth][j] = true;
                }
                //2.向左
                for(int j=0;j<i;j++){
                    used[depth][j]=true;
                }
                //3.左上
                int h = depth;
                int s = i;
                while ((--h>=0)&&(--s>=0)){
                    used[h][s]=true;
                }
                //4.左下
                h=depth;
                s=i;
                while((++h<n)&&(--s>=0)){
                    used[h][s]=true;
                }
                //5.右上
                h=depth;
                s=i;
                while((++s)<n&&(--h>=0)){
                    used[h][s]=true;
                }
                //6.右下
                h=depth;
                s=i;
                while((++s)<n&&(++h<n)){
                    used[h][s]=true;
                }
                //7.上
                h=depth;
                s=i;
                while(--h>0){
                    used[h][s]=true;
                }
                //8.下
                h=depth;
                s=i;
                while (++h<n){
                    used[h][s]=true;
                }
                dfs(n,depth+1,result);
                //reverse
                used = temp;
                board[depth][i]='.';
            }

        }
    }
}
