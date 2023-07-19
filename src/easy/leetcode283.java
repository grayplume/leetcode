package easy;

public class leetcode283 {
    // 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
    // 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
    
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num+" ");
        }
        
    }

    public static void moveZeroes(int[] nums) {
        // 判断数组为空的情况
        if(nums == null){
            return;
        }
        // 修改后下标
        int j = 0;
        for(int i = 0;i < nums.length;i++){
            // 当非0的值进行下面操作，将其存储到修改后的下标所在位置
            if(nums[i]!=0){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }
}
