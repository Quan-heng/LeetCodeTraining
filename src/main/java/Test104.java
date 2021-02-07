import java.util.LinkedList;
import java.util.Queue;

public class Test104 {
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

    //1.递归法
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = 0;
        int rightDepth = 0;
        leftDepth += maxDepth(root.left);
        rightDepth += maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    //2.队列法
    public static int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int result = 0;
        TreeNode curNode;
        Queue<TreeNode> subQueue;
        while (!queue.isEmpty()) {
            result++;
            subQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                curNode = queue.remove();
                if (curNode.left != null) {
                    subQueue.add(curNode.left);
                }
                if (curNode.right != null) {
                    subQueue.add(curNode.right);
                }
            }
            queue = subQueue;
        }
        return result;


    }
}
