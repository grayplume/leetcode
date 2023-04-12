package easy;

public class leetcode704 {
    public static void main(String[] args) {
        int nums[] ={-1,0,3,5,9,12};
        int ans = search(nums, 3);
        System.out.println(ans);
    }


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
