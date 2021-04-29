package 五毒.第七周.第一遍;

public class Test {
    public static void main(String[] args) {
         // 返回 True
        char[][] board  = new char[][]{
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };

        surrounded_regions sr = new surrounded_regions();
        sr.solve(board);
    }
}
