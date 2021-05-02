package 五毒.第七周.第一遍;

public class valid_sudoku {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][10];
        int[][] col = new int[9][10];
        int[][] block = new int[9][10];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                int curNum = block[i][j]-'0';
                int blockIndex  = (i/3)*3+j/3;
                if(row[i][curNum]==1||col[j][curNum]==1||block[blockIndex][curNum]==1){
                    return false;
                }
                row[i][curNum]=1;
                col[j][curNum]=1;
                block[blockIndex][curNum]=1;
            }
        }
        return true;
    }
}
