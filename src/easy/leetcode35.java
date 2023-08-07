package easy;

public class leetcode35 {
    // 35. 搜索插入位置

    public static void main(String[] args) {
        int[] a = {1,3,5,6};
        
        // searchInsert(a, 5);
        System.out.println(binarySearch(a, 5));
    }

  

    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int l=0,r=n-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]<target)
                l=mid+1;
            else r=mid-1;
        }
        return l;
    }


    public static int binarySearch(int[] nums,int target){
        int l =0,r = nums.length-1;
        
        while(l <= r){
            int m =(l + r) >>> 1;
            // 当目标值小于中间值,将右指针改为中间元素的右边
            if(target < nums[m]){
                r = m - 1;
            }else if(nums[m] < target){
                // 目标值大于中间值,将左指针移到中间元素右边一位
                l = m + 1;
            }else{
                return m;
            }
        }
        return r+1;
    }
}
