package 每日一题;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class word_search_ii {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            Set<String> visited = new HashSet<>();
            for(int i=0;i<word.length();i++){
                if(dfs(word.charAt(i),0,0,board,visited,word)){
                    result.add(word);
                }
            }
        }
        return result;
    }

    private boolean dfs(char curChar, int i,int j,char[][] board, Set<String> visited, String word) {
        if(i<0&&i>=board.length||j<0&&j>=board[0].length){
            return false;
        }
        return false;
    }
}
