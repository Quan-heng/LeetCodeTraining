package 五毒.第三周.第二遍;

import java.util.*;

public class serialize_and_deserialize_binary_tree {
    public String serialize(invert_binary_tree.TreeNode root) {
        if(root==null){
            return "X";
        }
        return root.val+","+serialize(root.left)+","+serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public invert_binary_tree.TreeNode deserialize(String data) {
        Deque<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return buildTree(queue);
    }

    public invert_binary_tree.TreeNode buildTree(Deque<String> queue){
        String val = queue.poll();
        if(val.equals("X")){
            return null;
        }
        invert_binary_tree.TreeNode root = new invert_binary_tree.TreeNode(Integer.valueOf(val));
        root.left = buildTree(queue);
        root.right = buildTree(queue);
        return root;
    }
}
