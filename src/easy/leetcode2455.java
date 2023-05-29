package easy;

public class leetcode2455 {
    // 2455. 可被三整除的偶数的平均值
    // 给你一个由正整数组成的整数数组 nums ，返回其中可被 3 整除的所有偶数的平均值。
    // 注意：n 个元素的平均值等于 n 个元素 求和 再除以 n ，结果 向下取整 到最接近的整数。

    public static void main(String[] args) {
        int a[] = {1,3,6,10,12,15};
        // System.out.println(averageValue(a));
        System.out.println(averageValue2(a));
    }

    public static int averageValue(int[] nums){
        int value = 0,count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]%3 == 0 && nums[i]% 2 == 0) {
                value += nums[i];
                count++;
            }
        }
        if (count == 0) {
            return 0;
        }
        return value/count;
    }

    public static int averageValue2(int[] nums){
        int count = 0;
        int sum = 0;
        for(int num : nums){
            if (num % 6 == 0) {
                ++count;
                sum += num;
            }
        }
        return count == 0 ? 0:sum / count;
    }

    

    
}
