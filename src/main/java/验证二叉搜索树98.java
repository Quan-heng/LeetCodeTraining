/**
 * 利用二叉搜索树中序遍历升序的特性，在遍历的过程中逐个和前一个元素比较，看是否大于前一个元素。
 */
public class 验证二叉搜索树98 {
    public static Long pre = Long.MIN_VALUE;
    public static void main(String[] args) {
       TreeNode node = new TreeNode(2);
       TreeNode node1 = new TreeNode(3);
       TreeNode node2 = new TreeNode(1);
       node.left  = node1;
       node.right = node2;
       System.out.println(isValidBST(node));
    }

    public static boolean isValidBST(TreeNode root) {
        //terminator
        //process
        //drill down
        if(root==null){
            return true;
        }
        if(!isValidBST(root.left)){
            return false;
        }
        if(root.val>pre){
            pre = (long)root.val;
        }else{
            return false;
        }
        if(!isValidBST(root.right)){
            return false;
        }
        //reverse
        return true;
    }
}
