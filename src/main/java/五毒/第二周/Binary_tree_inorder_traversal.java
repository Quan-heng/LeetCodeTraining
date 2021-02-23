package 五毒.第二周;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Binary_tree_inorder_traversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        //stack.push(root);
        while (root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            TreeNode temp = stack.pop();
            list.add(temp.val);
            root = temp.right;//重点理解这里
        }
        return list;
    }
}
