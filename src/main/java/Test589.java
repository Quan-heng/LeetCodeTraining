import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//前序遍历1.递归法，2.迭代法
public class Test589 {
    public static void main(String[] args) {

    }
    public static List<Integer> preorder(Node root) {
        Stack<Node> stack  = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            Node curNode = stack.pop();
            if(curNode!=null){
                result.add(curNode.val);
                for (int i = curNode.children.size() - 1; i >= 0; i--) {
                    stack.push(curNode.children.get(i));
                }
            }
        }
        return result;
    }
}
