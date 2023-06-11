package easy;

public class leetcode26 {
    // 26. 删除有序数组中的重复项
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(removeDuplicates(nums)); 
    }


    public static int removeDuplicates(int[] nums) {
         if(nums == null || nums.length == 0) return 0;
    int p = 0;
    int q = 1;
    while(q < nums.length){
        if(nums[p] != nums[q]){
            nums[p + 1] = nums[q];
            p++;
        }
        q++;
    }
    return p + 1;
    }
}
