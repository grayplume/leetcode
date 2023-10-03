package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode18 {
    // 18. 四数之和
    public static void main(String[] args) {
        // 测试用例
        int[] nums = { 1, 0, -1, 0, -2, 2 };
        int target = 0;
        System.out.println(fourSum(nums, target));

    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 剪枝操作
            if (nums[i] > 0 && nums[i] > target) {
                return result;
            }

            // 对nums[i]去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {
                // 剪枝操作
                if (nums[i] + nums[j] > 0 && nums[i] + nums[j] > target) {
                    break;
                }

                // 对nums[j]去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // 对nums[left]和nums[right]去重
                        while (right > left && nums[right] == nums[right - 1])
                            right--;
                        while (right > left && nums[left] == nums[left + 1])
                            left++;

                        left++;
                        right--;
                    }

                }
            }
        }
        return result;
    }

}
