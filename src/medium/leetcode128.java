package medium;

import java.util.HashSet;
import java.util.Set;

public class leetcode128 {
    // 128. 最长连续序列
    public static void main(String[] args) {
        int result = longestConsecutive(new int[] { 10, 1, 2, 3, 4, 5, 7, 8, 9 });
        System.out.println(result);
    }

    public static int longestConsecutive(int[] nums) {
        // 先存储到hash表
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longestStreak = 0;

        // 遍历hash表中的每一个元素
        for (int num : set) {
            // 如果hash表中不包含num-1，则表示num是第一个元素，从num开始，向右查找
            if (!set.contains(num - 1)) {
                int x = num + 1;
                // 向右查找，直到找到不存在的元素
                while (set.contains(x)) {
                    x++;
                }
                // 比较当前最长序列和x-num的长度，取最大值
                longestStreak = Math.max(longestStreak, x - num);
            }
        }
        return longestStreak;
    }
}
