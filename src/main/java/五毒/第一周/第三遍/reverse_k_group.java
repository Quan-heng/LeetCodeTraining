package 五毒.第一周.第三遍;

public class reverse_k_group {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int n = 0;
        ListNode start = head;
        ListNode curNode = head;
        while (n < k && head != null) {
            curNode = head;
            head = head.next;
            n++;
        }
        if (n == k) {
            ListNode pre = reverseKGroup(curNode.next, k);
            int i = 0;
            while (i < k) {
                ListNode nextTemp = start.next;
                start.next = pre;
                pre = start;
                start = nextTemp;
                i++;
            }
            return curNode;
        } else {
            return start;
        }
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
        ListNode node = reverseKGroup(node1, 3);
        System.out.println(node);
    }
}
