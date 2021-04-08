package 五毒.第三周.第二;

import java.util.Deque;
import java.util.LinkedList;

public class maximum_depth_of_binary_tree {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int depth = 0;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerFirst(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            depth++;
            for(int i=0;i<size;i++){
                TreeNode temp = queue.removeLast();
                if(temp.left!=null){
                    queue.offerFirst(temp.left);
                }
                if(temp.right!=null){
                    queue.offerFirst(temp.right);
                }
            }
        }
        return depth;

    }


    /**
     * dfs
     * @param root
     * @return
     */
    /*
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left = maxDepth(root.left)+1;
        int right  = maxDepth(root.right)+1;
        return Math.max(left,right);

    }*/
}
