package 五毒.第二周.第二遍;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class binary_tree_preorder_traversal {
    /**
     * bfs
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        while(root!=null||!queue.isEmpty()){
            while(root!=null){
                result.add(root.val);
                queue.push(root);
                root = root.left;
            }
            TreeNode temp = queue.pop();
            root = temp.right;
        }
        return result;
    }



    /**
     * dfs
     * @param root
     * @return
     */
    /*
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root!=null){
            result.add(root.val);
            result.addAll(preorderTraversal(root.left));
            result.addAll(preorderTraversal(root.right));
        }
        return result;
    }*/
}
