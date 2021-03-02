package 五毒.第一周.第一遍;

public class ReverseNodeInKGroup {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next  =node4;
        node4.next = node5;
        reverseKGroup(node1,2);
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head==null){
            return null;
        }
        ListNode start = head;//保存起点
        ListNode prev;
        int n = 0;
        while (head!=null){
            n++;
            head = head.next;
            if(n==k){//翻转前k个元素
                prev = reverseKGroup(head,k);//关键，递归。
                ListNode curNode = start;
                while (n>0){
                    ListNode temp = curNode.next; //保存后一个
                    curNode.next = prev; //指向前一个
                    prev = curNode;
                    curNode = temp;
                    n--;
                }
                return prev;
            }

        }
        return start; //原样返回
    }
}
