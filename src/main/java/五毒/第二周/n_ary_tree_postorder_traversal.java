package 五毒.第二周;

import java.util.*;

public class n_ary_tree_postorder_traversal {
    /**
     * 递归法
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
         List<Integer> result = new ArrayList<>();
         if(root!=null){
             root.children.forEach(a->{
                 result.addAll(postorder(a));
             });
             result.add(root.val);
         }
         return result;
    }

    /**
     * 跌代法
     * @param root
     * @return
     */
    public List<Integer> postorder1(Node root) {
        List<Integer> result= new ArrayList<>();
        if(root==null){
            return result;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            int size = stack.size();
            for(int i=0;i<size;i++){
                Node node  = stack.pop();
                result.add(node.val);
                for (Node child : node.children) {
                    stack.push(child);
                }
            }
        }
        Collections.reverse(result);
        return result;
    }
}
