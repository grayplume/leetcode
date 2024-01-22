package easy;

public class leetcode459 {
    public static void main(String[] args) {
        String s = "aba";
        boolean flag = repeatedSubstringPattern(s);
        System.out.println(flag);

    }

    // 459. 重复的子字符串
    // 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
    public static boolean repeatedSubstringPattern(String s) {
        if (s.equals(""))
            return false;

        int len = s.length();
        // 原串加个空格(哨兵) 使下标从1开始,这样j就是从0开始也不用初始化
        s = " " + s;
        char[] chars = s.toCharArray();
        int[] next = new int[len + 1];

        // 构造next数组 j从0开始对应的是空格 i从2开始
        for (int i = 2, j = 0; i <= len; i++) {
            // 匹配不成功,j回到前一位置next数组所对应的值
            while (j > 0 && chars[i] != chars[j + 1])
                j = next[j];
            // 匹配成功,j++
            if (chars[i] == chars[j + 1])
                j++;
            // 更新next数组
            next[i] = j; // 因为j从0开始，所以next[i] = j 对应的是next[j]的值，
        }
        // 判断是否有重复的子串,next[len]代表next数组末尾的值
        if (next[len] > 0 && len % (len - next[len]) == 0) {
            return true;
        }
        return false;
    }
}
