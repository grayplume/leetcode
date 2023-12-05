package easy;

public class leetcode343 {
    // 344. 反转字符串

    public static void main(String[] args) {
        char[] s = "abcdefg".toCharArray();
        reverseString(s);
        System.out.println(s);

    }

    public static void reverseString(char[] s) {
        int len = s.length;
        for (int i = 0, j = len - 1; i < len / 2; i++, j--) {
            swap(s, i, j);
        }
    }

    public static void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
