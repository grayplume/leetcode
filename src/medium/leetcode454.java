package medium;

import java.util.HashMap;
import java.util.Map;

public class leetcode454 {
    // 454. 四数相加 II

    public static void main(String[] args) {
        int[] nums1 = { 1, 2 };
        int[] nums2 = { -2, -1 };
        int[] nums3 = { -1, 2 };
        int[] nums4 = { 0, 2 };

        System.out.println(fourSumCount(nums1, nums2, nums3, nums4));

    }

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        // 统计两个数组中的元素之和，同时统计出现的次数
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        // 统计剩余的两个元素的和，在map中找是否存在相加为0的情况，同时记录次数
        for (int i : nums3) {
            for (int j : nums4) {
                res += map.getOrDefault(0 - i - j, 0);
            }
        }
        return res;
    }
}
