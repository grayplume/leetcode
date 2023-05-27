package medium;

public class leetcode31 {
    // 算法思路
    // 从右往左找到第一个降序的位置，记为 i，即 nums[i] < nums[i+1]。
    // 从右往左找到第一个比 nums[i] 大的位置，记为 j，即 nums[j] > nums[i]。
    // 交换 nums[i] 和 nums[j]。
    // 反转 nums[i+1:]。

    public static void main(String[] args) {
        int nums[] = {3,2,1};
        int[] b = nextPermutation(nums);
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }

    public static int[] nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
        return nums;
    }


    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    // public static int[] reverse(int[] a) {
    //     int length = a.length;
    //     int temp = 0;
    //     for (int i = 0; i < length / 2; i++) {
    //         temp = a[i];
    //         a[i] = a[length - i - 1];
    //         a[length - i - 1] = temp;
    //     }
    //     return a;
    // }
}
