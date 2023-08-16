package medium;

import java.util.Arrays;

public class leetcode34 {
    // 34.在排序数组中查找元素的第一个位置和最后一个位置
    public static void main(String[] args) {
        //
        int a[] = { 5, 7, 7, 8, 8, 10 };
        int target = 8;
        System.out.println(Arrays.toString(searchRange(a, target)));
    }

    public static int[] searchRange(int[] a, int target) {
        int x = leftMost(a, target);
        if (x == -1) {
            return new int[] { -1, -1 };
        } else {
            return new int[] { x, rightMost(a, target) };
        }
    }

    public static int leftMost(int[] a, int target) {
        int i = 0, j = a.length - 1;
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                candidate = m;
                j = m - 1;
            }
        }
        return candidate;
    }

    public static int rightMost(int[] a, int target) {
        int i = 0, j = a.length - 1;
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                candidate = m;
                i = m + 1;
            }
        }
        return candidate;
    }
}
