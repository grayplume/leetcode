package other;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = { 1, 5, 8, 11, 19, 22, 31, 35, 40, 45, 48, 49, 50 };
        int target = 450;
        int idx = binarySearch(array, target);
        System.out.println(idx);
    }

    // 二分查找。找到返回索引，找不到返回-1
    // 数组需要按照顺序排序
    public static int binarySearch(int[] a, int t) {
        int l = 0, r = a.length - 1, m;
        while (l <= r) {
            // m = (l + r) / 2;
            m = l + (r - l) / 2;
            if (a[m] == t) {
                return m;
            } else if (a[m] > t) {
                // 值在左边
                r = m - 1;
            } else {
                // 值在右边
                l = m + 1;
            }
        }
        return -1;
    }
}
// m = (l + r) / 2; //存在整数溢出问题
// l/2+r/2 ==> l-l/2+r/2 ==> l+(r-l)/2