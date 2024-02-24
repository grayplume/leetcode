package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode49 {
    // 49. 字母异位词分组
    // 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
    // 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
    public static void main(String[] args) {
        String[] str = { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> unique = groupAnagrams(str);
        System.out.println(unique);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        // 边界条件判断
        if (strs == null || strs.length == 0)
            return new ArrayList<>();
        // map中key存储的是字符串中字母排序后新的字符串
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            // 取出字符串，然后把它转化为字符数组
            char[] c = strs[i].toCharArray();
            // 对字符数组进行排序
            Arrays.sort(c);
            // 排序之后再把它转化为一个字符串
            String keyStr = String.valueOf(c);
            // 判断map中有没有这个字符串，如果没有这个字符串，
            // 说明还没有出现和这个字符串一样的字母异位词，
            // 要新建一个list，把它存放到map中
            if (!map.containsKey(keyStr))
                map.put(keyStr, new ArrayList<>());
            // 把字符串存放到对应的list中
            map.get(keyStr).add(strs[i]);
        }
        // 最后返回
        return new ArrayList<>(map.values());
    }

}