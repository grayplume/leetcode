package easy;

import java.util.HashSet;

public class leetcode349 {
    // 349. 两个数组的交集
    public static void main(String[] args) {

    }

    // 方法一：使用HashSet
    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 ||
                nums2 == null || nums2.length == 0) {
            return new int[0];
        }

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> resSet = new HashSet<>();

        // 遍历数组1
        for (int i : nums1) {
            set1.add(i);
        }

        // 遍历数组2的过程中判断哈希表中是否存在该元素
        for (int i : nums2) {
            if (set1.contains(i)) {
                resSet.add(i);
            }
        }
        // 将结果集合转为数组
        // return resSet.stream().mapToInt(x -> x).toArray();
        // 或者另外申请数组
        int[] arr = new int[resSet.size()];
        int j = 0;
        for (int i : resSet) {
            arr[j++] = i;
        }
        return arr;
    }

    // 方式二：使用Hash数组

}