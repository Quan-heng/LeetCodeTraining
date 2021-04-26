package 五毒.第七周.第一遍;

public class Test {
    public static void main(String[] args) {
         // 返回 True
        char[][] board = new char[][]{
                {'o','a','a','n'},
                {'a','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        word_search_ii wi = new word_search_ii();
        System.out.println(wi.findWords(board,new String[]{
                "oath",
                "pea",
                "eat",
                "rain",
                "hklf",
                "hf"
        }));

    }
}
