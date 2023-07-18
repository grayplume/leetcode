package easy;


public class leetcode21 {

    // 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

    public static void main(String[] args) {
        // 创建第一个链表 [1, 2, 4]
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        // 创建第二个链表 [1, 3, 4]
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);


        printLinkedList(mergeTwoLists(list1,list2));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 如果list1为空，则直接返回list2，表示将list2合并到list1中
        if (list1 == null) {
            return list2;
        }
        // 如果list2为空，则直接返回list1，表示将list1合并到list2中
        else if (list2 == null) {
            return list1;
        }
        // 如果list1的值小于list2的值，则将list1的下一个节点与list2合并，
        // 并将list1作为新的头节点返回
        else if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
        // 如果list2的值小于等于list1的值，则将list2的下一个节点与list1合并，
        // 并将list2作为新的头节点返回
        else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    // 打印链表
    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

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
