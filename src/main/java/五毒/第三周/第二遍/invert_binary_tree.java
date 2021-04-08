package 五毒.第三周.第二遍;

public class invert_binary_tree {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode node = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(node);
        return root;

    }
}
