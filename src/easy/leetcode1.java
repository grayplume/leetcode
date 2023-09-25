package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leetcode1 {
    // 1. 两数之和
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        int target = 8;
        System.out.println(Arrays.toString(twoSum(nums, target)));

    }

    // map求解
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i]; // 遍历当前元素，并在map中寻找是否存在匹配的key
            if (map.containsKey(temp)) {
                res[1] = i;
                res[0] = map.get(temp);
                break;
            }
            map.put(nums[i], i); // 如果没找到匹配对，就把访问过的元素和下标存入map中
        }
        return res;
    }
}
