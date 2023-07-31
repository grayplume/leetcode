package medium;

import java.util.ArrayList;
import java.util.List;

public class leetcode143 {
    // 143. 重排链表

    public static void main(String[] args) {
        // 创建第一个链表 [1, 2, 3, 4]
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(4);

        reorderList(list1);
        printLinkedList(list1);

    }

    public static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        // 创建有下标的列表
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode node = head;
        // 将链表节点存入列表
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        // 定义左右指针
        int i = 0, j = list.size() - 1;
        while (i < j) {
            // 左指针下一位等于右指针节点
            list.get(i).next = list.get(j);
            i++;

            if (i == j) {
                break;
            }

            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;

    }

    // 打印链表
    public static void printLinkedList(ListNode head) {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
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
