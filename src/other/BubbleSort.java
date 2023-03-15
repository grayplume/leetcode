package other;

import java.util.Arrays;
// 依次比较数组中相邻的两个元素大小,若a[j]>a[j+1],则交换两个元素,
// 两两都比较一次称为一轮冒泡,结果将最大的数排到最后
public class BubbleSort {
    public static void main(String[] args) {
        // int[] a = { 5, 9, 7, 4, 1, 3, 2, 8 };
        int[] a ={1,2,3,4,5,6,7,8,9};
        bubble_v2(a);
    }

    // 改进3:记录最后一次交换的索引,下一轮冒泡多少次
    public static void bubble_v2(int[] a) {
        int n = a.length - 1;
        while (true) {
            int last = 0;// 表示最后一次交换索引位置
            for (int i = 0; i < n; i++) {
                System.out.println("比较次数:" + i);
                if (a[i] > a[i + 1]) {
                    swap(a, i, i + 1);
                    last = i;
                }
            }
            n = last;
            System.out.println("冒泡" + Arrays.toString(a));
            if(n==0){
                break;
            }
        }
    }

    public static void bubble(int[] a) {
        for (int j = 0; j < a.length - 1; j++) {
            // 一轮冒泡
            // 改进2:当数组排列好时,无需再比较,可以根据是否发生交换判断是否排序完成
            boolean swapped = false;// 是否发生交换
            // 改进1:逐次比较次数递减 a.length-1 ->a.length-1-j
            for (int i = 0; i < a.length - 1 - j; i++) {
                System.out.println("比较次数:" + i);
                if (a[i] > a[i + 1]) {
                    swap(a, i, i + 1);
                    swapped = true;
                }
            }
            System.out.println("第" + j + "轮冒泡" + Arrays.toString(a));
            if (!swapped) {
                break;// 减少冒泡次数
            }
        }
    }

    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
