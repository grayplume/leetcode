package medium;

import java.util.Arrays;

public class leetcode16 {
    // 16. 最接近的三数之和
    public static void main(String[] args) {

        int nums[] = { -1, 2, 1, -4 };
        int target = 1;
        System.out.println(threeSumClosest(nums, target));

    }

    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        // 最接近的值
        int closed = Integer.MAX_VALUE;

        // 循环
        for (int i = 0; i < nums.length - 2; i++) {
            // 双指针

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];
                // 计算相差绝对值
                int value = Math.abs(sum - target);
                if (value < Math.abs(closed - target)) {
                    closed = sum;
                }

                // 移动双指针
                if (sum < target) {
                    left++;
                } else if (target < sum) {
                    right--;
                } else {
                    return sum;
                }
            }

        }

        return closed;
    }

}