package medium;

public class leetcode19 {
    // 19. 删除链表的倒数第 N 个结点

    public static void main(String[] args) {
        int[] elements = { 1, 2, 3, 4, 5 };
        printLinkedList(removeNthFromEnd(linkedlist(elements), 2));

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode fastIndex = dummyNode;
        ListNode slowIndex = dummyNode;

        // 快慢指针差n个节点
        for (int i = 0; i < n; i++) {
            fastIndex = fastIndex.next;
        }

        while (fastIndex.next != null) {
            fastIndex = fastIndex.next;
            slowIndex = slowIndex.next;
        }

        // slowIndex为删除元素的前一个节点
        slowIndex.next = slowIndex.next.next;
        return dummyNode.next;
    }

    public static ListNode linkedlist(int[] elements) {
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
        return head;
    }

    public static void printLinkedList(ListNode head) {
        // 打印链表元素
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

    // Definition for singly-linked list.
    public static class ListNode {
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

}
