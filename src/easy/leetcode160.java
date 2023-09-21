package easy;

public class leetcode160 {
    // 160. 相交链表
    public static void main(String[] args) {
        int[] element1 = { 4, 1, 8, 4, 5 };
        int[] element2 = { 5, 6, 1, 8, 4, 5 };

        getIntersectionNode(
                linkedlist(element1), linkedlist(element2));

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0, lenB = 0;
        while (curA != null) {
            lenA++;
            curA = curA.next;
        }
        while (curB != null) {
            lenB++;
            curB = curB.next;
        }

        curA = headA;
        curB = headB;
        // 让curA成为最长链表的头，lenA为其长度
        if (lenB > lenA) {
            int tmpLen = lenA;
            lenA = lenB;
            lenB = tmpLen;

            ListNode tmpNode = curA;
            curA = curB;
            curB = tmpNode;
        }

        // 求长度差
        int gap = lenA - lenB;
        // 同一起点
        while (gap-- > 0) {
            curA = curA.next;
        }
        // 遍历curA和curB 遇到相同返回
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;

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
