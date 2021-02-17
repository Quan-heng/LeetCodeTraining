import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 解题思路：BFS,DFS
 */
 class Test515 {
    /**
     * BFS
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        Deque<TreeNode> stack  = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            int max = Integer.MIN_VALUE;
            int size = stack.size();
            for(int i=0;i<size;i++){
                TreeNode temp = stack.pop();
                max = Math.max(max,temp.val);
                if(temp.left!=null){
                    stack.addLast(temp.left);
                }
                if(temp.right!=null){
                    stack.addLast(temp.right);
                }
            }
            result.add(max);

        }
        return result;
    }

    /**
     * DFS,将结点深度做为递归参数
     * @param root
     * @return
     */
    public List<Integer> largestValuesDFS(TreeNode root){
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> result= new ArrayList<>();
        dfs(result,root,0);
        return result;
    }

    private void dfs(List<Integer> result, TreeNode root, int depth) {
        if(root==null){
            return;
        }
        if(result.size()==depth){
            result.add(root.val);//第一次到达该depth时直接添加
        }else{
            result.set(depth,Math.max(result.get(depth),root.val));//与之前该depth的元素进行比较
        }
        dfs(result,root.left,depth+1);
        dfs(result,root.right,depth+1);
    }
}
