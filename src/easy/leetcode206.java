package easy;

public class leetcode206 {
    public static void main(String[] args) {

    }

    public class ListNode {
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

    // 双指针法
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;
        while (cur != null) {
            // 记录当前节点的下一个节点
            tmp = cur.next;
            // 然后将当前节点指向pre
            cur.next = pre;
            // pre和cur都前进一位
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    // 递归
    public ListNode reverseList2(ListNode head) {
        return reverse(null, head);
    }

    public static ListNode reverse(ListNode prev, ListNode cur) {
        if (cur == null) {
            return prev;
        }
        ListNode temp = null;
        temp = cur.next; // 先保存下一个节点
        cur.next = prev; // 反转
        // 位置相反
        return reverse(cur, temp);
    }

}
