package medium;

public class leetcode209 {
    // 209.长度最小的子数组

    public static void main(String[] args) {
        int nums[] = { 2, 3, 1, 2, 4, 3 };
        int target = 7;

        int result = minSubArrayLen(target, nums);
        System.out.println(result);
    }

    public static int minSubArrayLen(int target, int[] nums) {

        // 定义滑动窗口
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            // 数组之和大于等于目标值时
            while (target <= sum) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }
        // 如果result还是等于最大，那就是没找到
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
