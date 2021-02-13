package 训练场;

/**
 * 给定一个分布为二叉树状的村庄，村庄晚上很黑，现考虑在树的节点上安装路灯。
 * 节点上的路灯可以照亮自己和直接周围节点 (包括父节点，左儿子，右儿子)。
 * 请计算要让村庄都亮起来的最少路灯数量。
 *
 * 提示：
 * 给定树的节点数的范围是 [1, 1000] 且每个节点的值都是 0.
 *
 * 示例一：
 *
 * 输入：
 * [0,0,null,0,0]
 * 输出：
 * 1
 *
 * 解释：
 * 根据输入画出树，可知一个路灯都可以照亮。
 *
 * 示例二：
 *
 * 输入：
 * [0,0,null,0,null,0,null,null,0]
 * 输出：
 * 2
 *
 *
 * 树结构如下,x 表示树节点，1 表示安装的路灯所在位置：
 * 解题思路：求左右子树的最大深度，（左+1）/2+(右+1)/2
 * 注意边界条界，空和一个结点的情况
 */
public class 安装路灯 {
    public int minCameraCover(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left == 0 && right == 0) {
            return 1;
        }
        return (left + 1) / 2 + (right + 1) / 2;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left) + 1;
        int rightDepth = maxDepth(root.right) + 1;
        return Math.max(leftDepth, rightDepth);
    }
}
