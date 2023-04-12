package medium;

public class leetcode11 {
    public static void main(String[] args) {
        int []height ={2,3,4,5,18,17,6};
        int ans=doublePointer(height);
        System.out.println(ans);
    }

    public static int violated(int[] height) {
        //超时了
        int ans = 0;
        int value = 0;
        for(int l = 0;l<height.length;l++){          
            for(int r=l+1;r<height.length;r++){
                if(height[l]<height[r]){
                    value = (r-l)*height[l];
                }else{
                    value = (r-l)*height[r];
                }
                ans = ans > value ? ans: value;
            }
        }
        return ans;
    }

    public static int doublePointer(int[] height) {
        //双指针求解
        int ans = 0;
        int l = 0,r = height.length-1;//定义左右指针         
            while(l<r){
                int value = height[l]<height[r]? 
                    (r-l)*height[l++]:
                    (r-l)*height[r--];
                ans = ans > value ? ans: value;
            }
        return ans;
    }
}
