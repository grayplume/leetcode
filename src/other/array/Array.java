package other.array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class Array {

    public static void main(String[] args) {
        dynamicArray dynamicArray = new dynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);

        dynamicArray.add(2, 5);

        // 遍历1
        dynamicArray.forEach((element) -> {
            System.out.println(element);
        });

        // for (Integer element : dynamicArray) { // hasNext next
        // System.out.println(element);
        // }

        // dynamicArray.stream().forEach(element -> {
        // System.out.println(element);
        // });

        // delete test
        // int removed = dynamicArray.remove(2);
        // System.out.println(removed);
        // System.out.println("========");
        // dynamicArray.stream().forEach(element -> {
        // System.out.println(element);
        // });

    }

    public static class dynamicArray implements Iterable<Integer> {
        private int size = 0; // 逻辑大小
        private int capacity = 8; // 容量
        private int[] array = {};

        private void checkAndGrow() {
            // 容量检查
            if (size == 0) {
                array = new int[capacity];
            } else if (size == capacity) {
                // 进行扩容, 1.5 1.618 2
                capacity += capacity >> 1;
                int[] newArray = new int[capacity];
                System.arraycopy(array, 0,
                        newArray, 0, size);
                array = newArray;
            }
        }

        /**
         * 向最后位置添加元素
         * 
         * @param element
         */
        public void addLast(int element) {
            // array[size] = element;
            // size++;
            add(size, element);
        }

        /**
         * 向 [0 .. size] 位置添加元素
         * 
         * @param index   索引位置
         * @param element 待添加元素
         */
        public void add(int index, int element) {
            checkAndGrow();
            if (index >= 0 && index < size) {
                System.arraycopy(array, index, array, index + 1, size - index);
            }
            array[index] = element;
            size++;
        }

        /**
         * 获取元素
         * 
         * @param index
         * @return
         */
        public int get(int index) {
            return array[index];
        }

        /**
         * 删除元素
         * 
         * @param index [0 .. size]
         * @return
         */
        public int remove(int index) {
            int removed = array[index];
            System.arraycopy(array, index + 1, array, index, size - index - 1);
            size--;
            return removed;
        }

        // 遍历方法1
        public void foreach(Consumer<Integer> consumer) {
            for (int i = 0; i < size; i++) {
                // System.out.println(array[i]);
                consumer.accept(array[i]);
            }
        }

        // 遍历方法2 迭代器
        @Override
        public Iterator<Integer> iterator() {
            return new Iterator<Integer>() {
                int i = 0;

                @Override
                public boolean hasNext() { // 有没有下一个元素
                    return i < size;
                }

                @Override
                public Integer next() { // 返回当前元素并移动到下一个元素
                    return array[i++];
                }
            };

        }

        // 遍历方法3 流
        public IntStream stream() {
            return IntStream.of(Arrays.copyOfRange(array, 0, size));
        }
    }

}
