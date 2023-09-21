package medium;

public class leetcode24 {
    // 24. 两两交换链表中的节点
    public static void main(String[] args) {
        int elements[] = { 1, 2, 3, 4 };

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

        ListNode swapPairs = swapPairs2(head);

        // 打印链表元素
        ListNode current = swapPairs;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 获取当前节点的下一节点
        ListNode next = head.next;

        // 进行递归
        ListNode newNode = swapPairs(next.next);

        // 交换
        next.next = head;
        head.next = newNode;

        return next;
    }

    public static ListNode swapPairs2(ListNode head) {
        ListNode dumyhead = new ListNode(-1);
        dumyhead.next = head;

        ListNode cur = dumyhead;
        ListNode temp; // 临时节点，保存两个节点后面的节点
        ListNode firstnode; // 临时节点，保存两个节点中的第一节点
        ListNode secondnode; // 临时节点，保存两个节点中的第二节点

        while (cur.next != null && cur.next.next != null) {
            temp = cur.next.next.next;
            firstnode = cur.next;
            secondnode = cur.next.next;

            cur.next = secondnode;
            secondnode.next = firstnode;
            firstnode.next = temp;

            cur = firstnode;
        }

        return dumyhead.next;
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
