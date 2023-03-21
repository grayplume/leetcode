package easy;

import java.util.Arrays;

public class leetcode27 {
    public static void main(String[] args) {
        int nums[]={0,1,2,2,3,0,4,2};
        int val = 2;
        // int nums[]={};
        // int val = 0;

        int ans = violence(nums, val);
        // int ans = doublePointer(nums, val);
        
        System.out.println(ans);
    }

    public static int violence(int[] nums, int val){
        //暴力求解
        int size = nums.length;
        int i = 0;
        while(i < size) {
            if (nums[i]==val) {
                for (int j = i+1; j < size; j++) {
                    nums[j-1]=nums[j];  
                }
                size--;//每次找到删除的值，size减一  
            }else{
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return size;
    }

    public static int doublePointer(int[] nums, int val){
        //双指针求解
        int size = nums.length;
        int left = 0;
        for (int right = 0; right < size; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
    
}
