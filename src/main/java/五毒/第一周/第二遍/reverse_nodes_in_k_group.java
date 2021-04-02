package 五毒.第一周.第二遍;

public class reverse_nodes_in_k_group {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode headTemp = head;
        if(head==null||head.next==null){
            return head;
        }
        int len = 0;
        while(headTemp!=null){
            len++;
            headTemp = headTemp.next;
        }
        if(len<k){
            return head;
        }
        int i = 0;
        ListNode temp = head;
        headTemp = head;
        while(i<k){
            temp = headTemp;
            headTemp = headTemp.next;
            i++;
        }
        ListNode newHead = temp;
        ListNode nextHead = temp.next;
        headTemp =head;
        i = 0;
        ListNode prev = reverseKGroup(nextHead,k);
        while(i<k){
           ListNode nextTemp = headTemp.next;
           headTemp.next = prev;
           prev = headTemp;
           headTemp = nextTemp;
           i++;
        }

        return newHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode node = reverseKGroup(node1,3);
        System.out.println(node);
    }
}
