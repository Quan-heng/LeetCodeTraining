public class Test24 {
    public static void main(String[] args) {

    }

    public static ListNode swapPairs(ListNode head) {
        if(head==null){
            return null;
        }if(head.next == null){
            return head;
        }
        ListNode newHead = head.next;
        ListNode temp = head.next.next;
        newHead.next = head;
        head.next = swapPairs(temp);
        return newHead;
    }
}
