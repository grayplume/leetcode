package easy;

public class leetcode704 {
    // 704.二分查找
    public static void main(String[] args) {
        int nums[] = { -1, 0, 3, 5, 9, 12 };
        int ans = search3(nums, 3);
        System.out.println(ans);
    }

    // 基础版二分查找
    public static int search1(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) >>> 1;
            if (target < nums[m]) {
                r = m - 1;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    // 二分查找 左闭右开
    public static int search2(int[] nums, int target) {
        int l = 0, r = nums.length; // 1
        while (l < r) { // 3
            int m = (l + r) >>> 1;
            if (target < nums[m]) {
                r = m; // 2
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    // 二分查找 平衡版
    public static int search3(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (1 < r - l) {
            int m = (l + r) >>> 1;
            if (target < nums[m]) {
                r = m;
            } else {
                l = m;
            }
        }
        return (nums[l] == target) ? l : -1;
    }

    // old
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

}
