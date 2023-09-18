package easy;

public class leetcode203 {
    // 203. 移除链表元素
    public static void main(String[] args) {
        int elements[] = { 1, 2, 6, 3, 4, 5, 6 };

        ListNode head = null;
        ListNode tail = null;

        for (int element : elements) {
            ListNode newNode = new ListNode(element);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        int val = 6;
        removeElements(head, val);

        // 打印链表元素
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

    /**
     * 添加虚节点方式
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        // 设置虚拟头节点方便操作 dummy节点统一操作
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    /**
     * 不添加虚节点方式
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public static ListNode removeElements2(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        // head为null 退出
        if (head == null) {
            return head;
        }
        // 当前head.val != val
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    /**
     * 不添加虚拟节点and pre Node方式
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public static ListNode removeElements3(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.next.val == val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;
    }

}

class ListNode {
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