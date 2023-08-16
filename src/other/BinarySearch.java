package other;

public class BinarySearch {
    public static void main(String[] args) {
        // int[] array = { 1, 5, 8, 11, 19, 22, 31, 35, 40, 45, 48, 49, 50 };
        int[] array = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35, 37, 39, 41, 43, 45, 47, 49,
                51, 53, 55, 57, 59, 61, 63, 65, 67, 69 };
        int target = 5;
        int idx = binarySearch(array, target);
        int idx2 = binarySearch2(array, target);
        System.out.println(idx);
        System.out.println("----------------");
        System.out.println(idx2);
    }

    // 二分查找。找到返回索引，找不到返回-1
    // 数组需要按照顺序排序
    public static int binarySearch(int[] a, int t) {
        long start = System.nanoTime();
        int l = 0, r = a.length - 1, m;
        while (l <= r) {
            // m = (l + r) / 2;
            m = l + (r - l) / 2;
            if (a[m] == t) {
                long end = System.nanoTime();
                System.out.println(end - start + "纳秒01");
                return m;
            } else if (a[m] > t) {
                // 值在左边
                r = m - 1;
            } else {
                // 值在右边
                l = m + 1;
            }
        }
        long end = System.nanoTime();
        System.out.println(end - start + "纳秒01");
        return -1;
    }
    // m = (l + r) / 2; //存在整数溢出问题
    // l/2+r/2 ==> l-l/2+r/2 ==> l+(r-l)/2

    // 插值查找，要求数据分布比较均匀,数据量比较大时比二分查找快
    // 数组需要按照顺序排序
    public static int binarySearch2(int[] a, int t) {
        long start = System.nanoTime();
        int l = 0, r = a.length - 1, m;
        while (l <= r) {
            // 计算目标值在数组中的大致位置
            m = l + (t - a[l]) / (a[r] - a[l]) * (r - l);
            if (a[m] == t) {
                long end = System.nanoTime();
                System.out.println(end - start + "纳秒02");
                return m;
            } else if (a[m] > t) {
                // 值在左边
                r = m - 1;
            } else {
                // 值在右边
                l = m + 1;
            }
        }
        long end = System.nanoTime();
        System.out.println(end - start + "纳秒02");
        return -1;
    }

    // 二分查找LeftMost 返回最左边的目标值
    public static int binarysearchLeftmost1(int[] a, int target) {
        int l = 0, r = a.length - 1;
        int candidate = -1;
        while (l <= r) {
            int m = (l + r) >>> 1;
            if (target < a[m]) {
                r = m - 1;
            } else if (a[m] < target) {
                l = m + 1;
            } else {
                // 记录候选位置
                candidate = m;
                r = m - 1;
            }
        }
        return candidate;
    }

    // 二分查找RightMost 返回最右边的目标值
    public static int binarysearchRightmost1(int[] a, int target) {
        int l = 0, r = a.length - 1;
        int candidate = -1;
        while (l <= r) {
            int m = (l + r) >>> 1;
            if (target < a[m]) {
                r = m - 1;
            } else if (a[m] < target) {
                l = m + 1;
            } else {
                // 记录候选位置
                candidate = m;
                l = m + 1;
            }
        }
        return candidate;
    }

    // LeftMost 返回值优化，找到返回最左值
    // 没找到返回比目标值大的最左值
    public static int binarysearchLeftmost2(int[] a, int target) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int m = (l + r) >>> 1;
            if (target <= a[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    // RightMost 返回值优化，找到返回最右值
    // 没找到返回比目标值小的最右值
    public static int binarysearchRightmost2(int[] a, int target) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int m = (l + r) >>> 1;
            if (target < a[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l - 1;
    }
}
