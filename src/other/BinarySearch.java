package other;

public class BinarySearch {
    public static void main(String[] args) {
        // int[] array = { 1, 5, 8, 11, 19, 22, 31, 35, 40, 45, 48, 49, 50 };
        int[] array = {1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35,37,39,41,43,45,47,49,51,53,55,57,59,61,63,65,67,69};
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
        System.out.println(end - start+ "纳秒02");
        return -1;
    }
}
