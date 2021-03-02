package 五毒.第三周;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int begin=0;
        dfs(result,list,begin,n,k);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> list, int begin,int n,int k) {
        if(list.size()==k){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=begin;i<n;i++){
            list.add(i);
            dfs(result,list,i+1,n,k);
            list.remove(list.size()-1);
        }
    }
}
