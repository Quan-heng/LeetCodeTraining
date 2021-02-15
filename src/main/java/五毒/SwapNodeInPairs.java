package 五毒;
//思路：递归
//1,2,3,4
//2,1,4,3
public class SwapNodeInPairs {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next  =node4;
        swapPairs(node1);
    }
    public static ListNode swapPairs(ListNode head) {
       if(head==null){
           return null;
       }
       if(head.next==null){
           return head;
       }
       ListNode temp = head.next.next;
       ListNode newHead = head.next;
       newHead.next = head;
       head.next = swapPairs(temp);
       return newHead;
    }
}
