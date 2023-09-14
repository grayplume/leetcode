package easy;

public class leetcode977 {
    // 977. 有序数组的平方
    public static void main(String[] args) {
        int nums[] = { -4, -1, 0, 3, 10 };
        int[] result = sortedSquares(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int[] sortedSquares(int[] nums) {
        // 双指针
        int left = 0;
        int right = nums.length - 1;
        // 定义结果数组
        int[] result = new int[nums.length];
        // 结果索引 从大到小
        int index = result.length - 1;

        // 左右双指针
        while (left <= right) {
            // 如果左边的平方大于右边的平方
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[index--] = nums[left] * nums[left];
                left++;
            } else {
                result[index--] = nums[right] * nums[right];
                right--;
            }
        }

        return result;
    }
}
