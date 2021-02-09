public class 二叉树的最近公共祖先 {
    public static void main(String[] args) {

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p == root || q == root) {
            return root;
        } else if (root.left != null) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.right != null) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return null;
        }
    }
}
