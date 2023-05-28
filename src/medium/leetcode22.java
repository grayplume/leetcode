package medium;

import java.util.ArrayList;
import java.util.List;

public class leetcode22 {
    // 数字 n 代表生成括号的对数，请你设计一个函数，
    // 用于能够生成所有可能的并且 有效的 括号组合。
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        // 创建数组
        List<String> combinations = new ArrayList<String>();
        // 调用 generateAll 函数，将生成的组合添加到 combinations 列表中
        generateAll(new char[2 * n], 0, combinations);
        // 返回所有组合的列表
        return combinations;
    }

    // 生成所有组合的函数
    public static void generateAll(char[] current, int pos, List<String> result) {
        // 如果当前位置已经到达数组末尾
        if (pos == current.length) {
            // 如果当前组合是有效的括号组合
            if (valid(current)) {
                // 将当前组合转换成字符串并添加到结果列表中
                result.add(new String(current));
            }
        } else {
            // 在当前位置放置左括号
            current[pos] = '(';
            // 继续生成下一个位置的组合
            generateAll(current, pos + 1, result);
            // 在当前位置放置右括号
            current[pos] = ')';
            // 继续生成下一个位置的组合
            generateAll(current, pos + 1, result);
        }
    }

    // balance变量等于0，那么这个组合就是有效的括号组合。
    public static boolean valid(char[] current) {
        int balance = 0;
        // 遍历当前组合中的每个字符
        for (char c : current) {
            // 如果当前字符是左括号，balance 变量加 1
            if (c == '(') {
                ++balance;
            } else {
                // 如果当前字符是右括号，balance 变量减 1
                --balance;
            }
            // 如果 balance 变量小于 0，说明当前组合不是有效的括号组合
            if (balance < 0) {
                return false;
            }
        }
        // 如果 balance 变量等于 0，说明当前组合是有效的括号组合
        return balance == 0;
    }
}
