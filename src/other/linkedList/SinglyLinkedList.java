package other.linkedList;

import java.util.Iterator;
import java.util.function.Consumer;

// 单向链表
public class SinglyLinkedList implements Iterable<Integer> { // 整体
    private Node head = null; // 头指针

    @Override
    public Iterator<Integer> iterator() {
        // 匿名内部类 -> 带名字内部类
        return new NodeIterator();
    }

    private final class NodeIterator implements Iterator<Integer> {
        Node p = head;

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
        head = new Node(value, head);
    }

    /**
     * 找到最后节点
     * 
     * @return
     */
    private Node findLast() {
        if (this.head == null) {
            return null;
        }
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
        if (last == null) {
            addFirst(value);
            return;
        }
        last.next = new Node(value, null);
    }

    /**
     * 遍历
     * 
     * @param consumer
     */
    public void loop1(Consumer<Integer> consumer) {
        Node p = head;
        while (p != null) {
            consumer.accept(p.value);
            p = p.next;
        }
    }

    public void loop2(Consumer<Integer> consumer) {
        for (Node p = head; p != null; p = p.next) {
            consumer.accept(p.value);
        }
    }

}
