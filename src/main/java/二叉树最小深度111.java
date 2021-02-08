/**
 *
 */
public class 二叉树最小深度111 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.right = node3;
        System.out.println(minDepth(node1));
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right != null) {//左子树为空，计算右子树的最小深度
            return minDepth(root.right) + 1;
        } else if (root.right == null && root.left != null) {//反之亦然
            return minDepth(root.left) + 1;
        } else {
            return Math.min(minDepth(root.left) + 1, minDepth(root.right) + 1);//继续向下遍历，直到出现空结点
        }
    }
}
