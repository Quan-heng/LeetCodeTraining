public class 二叉树的公共祖先 {
    public static void main(String[] args) {

    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(root==p||root==q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left==null&&right==null){ //left,right同时为空，说明root的左/右子树都不包含p,q,返回null
            return null;
        }
        if(left!=null&&right!=null){//left,right都不为空，说明在root的两侧，返回root
            return root;
        }
        if(left==null){//p,q都不在left，返回right
            return right;
        }
        if(right==null){//p,q都不在right,返回left
            return left;
        }
        return root;
    }
}
