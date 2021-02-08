/**
 * 考点：递归
 */
public class 二叉树最大深度104 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        root.left = node9;
        root.right = node20;
        node20.left = node15;
        node20.right = node7;
        System.out.println(maxDepth(root));

    }

    public static int maxDepth(TreeNode root) {
        int leftDepth = 0;
        int rightDepth = 0;
        if (root == null) {
            return 0;
        }
        leftDepth = maxDepth(root.left) + 1;
        rightDepth = maxDepth(root.right) + 1;
        return Math.max(leftDepth, rightDepth);
    }
}
