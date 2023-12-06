package medium;

public class leetcode151 {
    public static void main(String[] args) {

        String s = "the sky is blue";
        System.out.println(reverseWords(s));

    }

    public static String reverseWords(String s) {
        // 将字符串转换为字符数组
        char[] ch = s.toCharArray();
        // 1. 整体字符串反转
        reverse(ch, 0, s.length() - 1);
        // 用于记录新字符数组的索引
        int k = 0;
        // 2. 遍历字符串，将每个单词从后往前添加到新字符数组中
        for (int i = 0; i < ch.length; i++) {
            // 如果当前字符是空格，跳过
            if (ch[i] == ' ') {
                continue;
            }
            // 记录当前单词的起始位置
            int tempCur = i;
            // 遍历到当前单词的结束位置
            while (i < ch.length && ch[i] != ' ') {
                i++;
            }
            // 将当前单词的字符从后往前添加到新字符数组中
            for (int j = tempCur; j < i; j++) {
                // 对指定范围字符串进行反转，不反转从后往前遍历一个个填充有问题
                if (j == tempCur) {
                    reverse(ch, tempCur, i - 1);
                }
                // 将当前单词的字符添加到新字符数组中
                ch[k++] = ch[j];

                // 遍历结束
                if (j == i - 1) {
                    // 避免越界情况 不加判断最后就会数组越界
                    if (k < ch.length) {
                        ch[k++] = ' ';
                    }
                }
            }
        }
        // 如果新字符数组为空，返回空字符串
        if (k == 0) {
            return "";
        } else {
            // 防止出现正好凑满不需要省略空格的情况
            return new String(ch, 0, (k == ch.length) && (ch[k - 1] != ' ') ? k : k - 1);
        }
    }

    // 反转指定范围的字符串
    private static void reverse(char[] ch, int i, int j) {
        while (i < j) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
    }
}