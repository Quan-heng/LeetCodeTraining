package 五毒.第三周.第一遍;

/**
 * 思路：递归
 * 时间复杂度：o(n),n为树中的结点数量
 */
public class invert_binary_tree {
    public TreeNode invertTree(TreeNode root) {
        if(root ==null){
            return root;
        }
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}
