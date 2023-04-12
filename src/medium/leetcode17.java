package medium;

import java.util.List;
import java.util.ArrayList;

public class leetcode17 {
    public static void main(String[] args) {
        // 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
        // 答案可以按 任意顺序 返回。给出数字到字母的映射如下（与电话按键相同）。
        // 注意 1 不对应任何字母。

        String digits = "23";
        System.out.println(letterCombinations(digits));
    }


    public static List<String> letterCombinations(String digits) {
        // 创建一个空的字符串列表，用于存储结果集
        List<String> res = new ArrayList<>();
        // 如果输入字符串为空，直接返回结果列表
        if (digits == null || digits.length() == 0) {
            return res;
        }
        // 创建电话数字和字母的映射关系
        String[] map = new String[] {"", "", "abc", "def", 
                                    "ghi","jkl","mno","pqrs","tuv","wxyz"};
        // 调用递归函数，查找所有的字母组合
        helper(digits, 0, "", res, map);
        return res;
    }
    
    // 使用回溯法生成所有可能的字母组合
    private static void helper(String digits, int index, String path, List<String> res, String[] map) {
        // 当前的深度等于输入数字字符串的长度时，所有的数字都已经处理完了，
        // 因此将当前的字母组合添加到结果列表中
        if (index == digits.length()) {
            res.add(path);
            return;
        }
        // 获取当前数字对应的字母集合
        String letters = map[digits.charAt(index) - '0'];
        // 遍历当前数字对应的字母集合
        for (int i = 0; i < letters.length(); i++) {
            // 递归处理下一个数字所对应的字母组合
            helper(digits, index + 1, path + letters.charAt(i), res, map);
        }
    }
}
