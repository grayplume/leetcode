package easy;

public class leetcode383 {
    // 383. 赎金信
    public static void main(String[] args) {
        // 测试用例
        String ransomNote = "abbc";
        String magazine = "abc";
        System.out.println(canConstruct(ransomNote, magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        // 定义一个哈希映射数组
        int[] record = new int[26];

        // 遍历
        for (int c : magazine.toCharArray()) {
            record[c - 'a'] += 1;
        }
        for (int c : ransomNote.toCharArray()) {
            record[c - 'a'] -= 1;
        }

        // 如果数字中存在负数 说明ransomNote字符串总存在maginze中没有的字符
        for (int i : record) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }

}
