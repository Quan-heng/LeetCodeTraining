package 五毒.第三周.第二遍;

import java.util.ArrayList;
import java.util.List;

public class combination {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if(n<k){
            return result;
        }
        int depth = 1;
        List<Integer> list = new ArrayList<>();
        dfs(result,depth,list,n,k);
        return result;
    }

    private static void dfs(List<List<Integer>> result, int depth, List<Integer> list,int n, int k) {
        if(list.size()==k){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = depth;i<=n;i++){
            list.add(i);
            dfs(result,i+1,list,n,k);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println( combine(4,2));
    }

}
