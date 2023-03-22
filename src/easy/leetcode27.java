package easy;

import java.util.Arrays;

public class leetcode27 {
    public static void main(String[] args) {
        int nums[]={0,1,2,2,3,0,4,2};
        int val = 2;
        // int nums[]={};
        // int val = 0;

        // int ans = violence(nums, val);
        // int ans = doublePointer(nums, val);
        int ans = doublePointer_v2(nums, val);
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

    public static int doublePointer_v2(int[] nums, int val) {
        // 相向双指针法
        // 基于元素顺序可以改变的题目描述改变了元素相对位置，确保了移动最少元素
        int left = 0;
        int right = nums.length - 1;
        while(right >= 0 && nums[right] == val) right--; //将right移到从右数第一个值不为val的位置
        while(left <= right) {
            if(nums[left] == val) { //left位置的元素需要移除
                //将right位置的元素移到left（覆盖），right位置移除
                nums[left] = nums[right];
                right--;
            }
            left++;
            while(right >= 0 && nums[right] == val) right--;
        }
        return left;
    }
    
}
