package leetcode.nov;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 17.电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *
 * @date: 2024/11/26 23:21
 * @author: dayue
 */
public class Main_1126_17 {
    static Map<String, String> numMap = new HashMap<>();
    static {
        numMap.put("2", "abc");
        numMap.put("3", "def");
        numMap.put("4", "ghi");
        numMap.put("5", "jkl");
        numMap.put("6", "mno");
        numMap.put("7", "pqrs");
        numMap.put("8", "tuv");
        numMap.put("9", "wxyz");
    }

    static Set<String> all = new HashSet<>();

    public static void main(String[] args) {
        List<String> strings = letterCombinations("455");
        strings.forEach(System.out::println);
    }

    // todo: 改成从没个数字取1位字符出来，现在的逻辑是从组成的字符串取子集，不对的，因为有可能造成一个数字取出两个字母
    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            String s = numMap.get(digits.charAt(i) + "");
            for (int j = 0; j < s.length(); j++) {
                chars.add(s.charAt(j));
            }
        }
        dfs("", 0, digits.length(), chars);
        return all.stream().filter(item -> {
            for (int i = 0; i < digits.length(); i++) {
                String s = numMap.get(digits.charAt(i) + "");
                boolean isContains = false;
                for (int j = 0; j < s.length(); j++) {
                    String currentCh = s.charAt(j) + "";
                    if (item.contains(currentCh)) {
                        isContains = true;
                    }
                }
                if (!isContains) {
                    return false;
                }
            }
            return true;
        }).collect(Collectors.toList());
    }

    public static void dfs(String currentStr, int index ,int size, List<Character> chars) {
        if (currentStr.length() == size) {
            all.add(currentStr);
            return;
        }
        if (index == chars.size()) {
            return;
        }
        currentStr = currentStr + chars.get(index);
        dfs(currentStr, index + 1, size, chars);
        currentStr = currentStr.substring(0, currentStr.length() - 1);
        dfs(currentStr, index + 1, size, chars);
    }
}
