package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode15 {
    //给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
    // 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
    // 注意：答案中不可以包含重复的三元组。


    public static void main(String[] args) {
        int[] a = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(a));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // 判断数组为空或者不足三个元素
        if (nums == null || nums.length <= 2) return ans;
        // 排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // 排序后第一个数大于0，不存在三数之和为0的情况
            if (nums[i] > 0) break;
            // 去掉重复的
            if (i > 0 && nums[i] == nums[i-1]) continue;
            // 目标值
            int target = -nums[i];
            // 左右指针
            int left = i + 1,right = nums.length - 1;

            while(left < right){
                if(nums[left] + nums[right] == target){
                    ans.add(new ArrayList<>(Arrays.asList(nums[i],nums[left],nums[right])));
                
                    left++; right--; // 首先无论如何先要进行加减操作
                    while(left < right && nums[left] == nums[left-1]) left++;
                    while(left < right && nums[right] == nums[right+1]) right--;
                }else if(nums[left] + nums[right] < target){ // 小了
                    left ++;
                }else{ // 大了
                    right --;
                }
            }
        }

        return ans;
    }
}
