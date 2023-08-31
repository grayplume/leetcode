package other.linkedList;

import java.util.Iterator;
import java.util.function.Consumer;

// 单向链表带哨兵
public class SinglyLinkedListSentinel implements Iterable<Integer> { // 整体
    private Node head = new Node(666, null); // 头指针->哨兵节点

    @Override
    public Iterator<Integer> iterator() {
        // 匿名内部类 -> 带名字内部类
        return new NodeIterator();
    }

    private final class NodeIterator implements Iterator<Integer> {
        Node p = head.next;

        @Override
        public boolean hasNext() { // 是否有下个元素
            return p != null;
        }

        @Override
        public Integer next() { // 返回当前值,指向下一元素
            int v = p.value;
            p = p.next;
            return v;
        }
    }

    /**
     * 节点类
     */
    private static class Node {
        int value; // 值
        Node next; // 下一个节点指针

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 向链表头部添加
     * 
     * @param value 值
     */
    public void addFirst(int value) {
        // 1.链表为空的情况
        // head = new Node(value, null);
        // 2.链表非空 既能处理空和非空
        // head = new Node(value, head);
        // 哨兵优化
        insert(0, value);
    }

    /**
     * 找到最后节点
     * 
     * @return
     */
    private Node findLast() {
        // if (this.head == null) { // 因为哨兵节点所以不存在为null的情况
        // return null;
        // }
        Node curr;
        for (curr = this.head; curr.next != null;) {
            curr = curr.next;
        }
        return curr;
    }

    /**
     * 向链表尾部添加
     * 
     * @param value 值
     */
    public void addLast(int value) {
        Node last = findLast();
        // if (last == null) { // 因为哨兵节点所以不存在为null的情况
        // addFirst(value);
        // return;
        // }
        last.next = new Node(value, null);
    }

    /**
     * 遍历
     * 
     * @param consumer
     */
    public void loop1(Consumer<Integer> consumer) {
        Node p = head.next;
        while (p != null) {
            consumer.accept(p.value);
            p = p.next;
        }
    }

    public void loop2(Consumer<Integer> consumer) {
        for (Node p = head.next; p != null; p = p.next) {
            consumer.accept(p.value);
        }
    }

    // public void test() {
    // int i = 0;
    // for (Node p = head; p != null; p = p.next, i++) {
    // System.out.println(p.value + "索引是:" + i);
    // }
    // }

    private Node findNode(int index) {
        // int i = 0;
        int i = -1; // 哨兵修改
        for (Node p = head; p != null; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null;// 没找到
    }

    public int get(int index) {
        Node node = findNode(index);
        if (node == null) {
            illegalIndex(index);
        }
        return node.value;
    }

    /**
     * 索引异常
     * 
     * @param index
     */
    private void illegalIndex(int index) {
        throw new IllegalArgumentException(String.format("index [%d] 不合法%n", index));
    }

    /**
     * 向索引位置插入
     */
    public void insert(int index, int value) {
        // if (index == 0) { // 哨兵简化
        // addFirst(value);
        // return;
        // }
        Node prev = findNode(index - 1); // 找到上一节点
        if (prev == null) {
            illegalIndex(index);
        }
        prev.next = new Node(value, prev.next);
    }

    /**
     * 删除首个元素
     */
    public void removeFirst() {
        // if (head == null) {
        // illegalIndex(0);
        // }
        // head = head.next;

        remove(0);
    }

    public void remove(int index) {
        // if (index == 0) { // 哨兵优化
        // removeFirst();
        // return;
        // }

        Node prev = findNode(index - 1);
        if (prev == null) {
            illegalIndex(index);
        }
        Node removed = prev.next; // 被删除的节点
        if (removed == null) {
            illegalIndex(index);
        }
        prev.next = removed.next;
    }
}
