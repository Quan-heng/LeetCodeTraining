package 五毒.第一周.第四遍;

public class swap_nodes_in_paris {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode temp= head.next.next;
        ListNode newHead = head.next;
        head.next.next = head;
        head.next = swapPairs(temp);
        return newHead;
    }
}
