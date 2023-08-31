package other.linkedList;

public class Test {
    public static void main(String[] args) {
        // SinglyLinkedList list = new SinglyLinkedList();
        SinglyLinkedListSentinel list = new SinglyLinkedListSentinel();

        // list.addFirst(1);
        // list.addFirst(2);
        // list.addFirst(3);
        // list.addFirst(4);

        // list.loop2(value -> {
        // System.out.println(value);
        // });

        // for (Integer value : list) {
        // System.out.println(value);
        // }

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        // list.loop1(value -> {
        // System.out.println(value);
        // });

        // list.test();

        // int i = list.get(0);
        // System.out.println(i);

        // list.insert(2, 5);
        // for (Integer value : list) {
        // System.out.println(value);
        // }

        // list.removeFirst();
        // for (Integer value : list) {
        // System.out.println(value);
        // }

        list.remove(0);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
