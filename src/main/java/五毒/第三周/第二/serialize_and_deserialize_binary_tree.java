package 五毒.第三周.第二;

import java.util.*;

public class serialize_and_deserialize_binary_tree {
    public String serialize(TreeNode root) {
        if(root==null){
            return "X";
        }
        return root.val+","+serialize(root.left)+","+serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return buildTree(queue);
    }

    public TreeNode buildTree(Deque<String> queue){
        String val = queue.poll();
        if(val.equals("X")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = buildTree(queue);
        root.right = buildTree(queue);
        return root;
    }
}
