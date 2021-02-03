import java.util.*;

//n叉树的后序遍历
public class Test590 {
    public static void main(String[] args) {
      Node emptyNode = null;
      postorder2(emptyNode);
    }

    public static List<Integer> postorder1(Node root) {
        //1.递归
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        for (int i = 0; i < root.children.size(); i++) {
            result.addAll(postorder1(root.children.get(i)));
        }
        result.add(root.val);
        return result;
    }

    public static List<Integer> postorder2(Node root) {
        //迭代法，用stack
        Stack<Node> sk = new Stack<>();
        List<Integer> result = new ArrayList<>();
        sk.push(root);
        while (!sk.isEmpty()) {
            Node curNode = sk.pop();
            if (curNode != null) {
                result.add(curNode.val);
                for (int i = 0; i < curNode.children.size(); i++) {
                    if(curNode.children.get(i)!=null){
                        sk.push(curNode.children.get(i));
                    }
                }
            }
        }
        Collections.reverse(result);
        return result;
    }
}
