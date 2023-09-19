package medium;

public class leetcode707 {
    // 707. 设计链表
    public static void main(String[] args) {

    }

    // 单链表
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        };

        ListNode(int val) {
            this.val = val;
        }
    }

    class MyLinkedList {
        // size存储链表元素的个数
        int size;
        // 虚拟头结点
        ListNode head;

        // 初始化链表
        public MyLinkedList() {
            size = 0;
            head = new ListNode(0);
        }

        // 获取第index个节点的数值
        public int get(int index) {
            // 如果index非法返回-1
            if (index < 0 || index >= size) {
                return -1;
            }
            ListNode currNode = head;
            // 包含一个虚拟节点，所以需要查找index+1个节点
            for (int i = 0; i <= index; i++) {
                currNode = currNode.next;
            }
            return currNode.val;
        }

        // 在链表最前面插入一个节点，等价于在第0个元素前添加
        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        // 在链表最前后插入一个节点，等价于在末尾+1个元素前添加
        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        // 按索引添加
        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if (index < 0) {
                index = 0;
            }
            size++;
            // 找到要插入节点的前驱
            ListNode pred = head;
            for (int i = 0; i < index; i++) {
                pred = pred.next;
            }
            ListNode toAdd = new ListNode(val);
            toAdd.next = pred.next;
            pred.next = toAdd;
        }

        // 删除第index个节点
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            size--;
            // 删除头结点
            if (index == 0) {
                head = head.next;
                return;
            }
            ListNode pred = head;
            for (int i = 0; i < index; i++) {
                pred = pred.next;
            }
            pred.next = pred.next.next;
        }

    }

    // 双链表
    class ListNode2 {
        int val;
        ListNode2 next, prev;

        ListNode2() {
        };

        ListNode2(int val) {
            this.val = val;
        }
    }

    class MyLinkedList2 {
        // 记录链表中元素的数量
        int size;
        // 记录链表中虚拟头结点和尾结点
        ListNode2 head, tail;

        public MyLinkedList2() {
            // 初始化操作
            this.size = 0;
            this.head = new ListNode2(0);
            this.tail = new ListNode2(0);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int index) {
            // 判断index是否有效
            if (index < 0 || index >= size) {
                return -1;
            }

            ListNode2 cur = this.head;
            // 判断是哪一边遍历的时间更短
            if (index >= size / 2) {
                // tail开始
                cur = tail;
                for (int i = 0; i <= size - index; i++) {
                    cur = cur.next;
                }
            }
            return cur.val;
        }

        public void addAtHead(int val) {
            // 等价与在第0个元素前添加
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            // 等价与在最后一个元素null前添加
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            // index大于链表长度
            if (index > size) {
                return;
            }
            // index小于0
            if (index < 0) {
                index = 0;
            }
            size++;
            // 找到前驱
            ListNode2 pre = this.head;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            // 建新结点
            ListNode2 newNode = new ListNode2(val);
            newNode.next = pre.next;
            pre.next.prev = newNode;
            newNode.prev = pre;
            pre.next = newNode;
        }

        public void deleteAtIndex(int index) {
            // 判断索引是否有效
            if (index < 0 || index >= size) {
                return;
            }
            // 删除操作
            size--;
            ListNode2 pre = this.head;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            pre.next.next.prev = pre;
            pre.next = pre.next.next;
        }

    }
}
