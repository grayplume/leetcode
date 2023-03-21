package medium;

import java.util.HashSet;
import java.util.Set;

public class leetcode287 {
    public static void main(String[] args) {
        int[] a = { 1, 3, 4, 2, 2 };
        // int ans=hash(a);
        int ans=violence(a);
        System.out.println(ans);
    }

    public static int hash(int[] nums) {
        //哈希表求解
        Set<Integer> seen = new HashSet<Integer>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }
        return -1;
    }

    public static int violence(int[] nums){
        //暴力求解
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]==nums[j]){
                    return nums[i];
                }
            }
        }
        return -1;
    }
}
