package hot100;

import java.util.HashSet;

/**
 * 无重复字符的最长子串
给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 示例 1:

 输入: s = "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 示例 2:

 输入: s = "bbbbb"
 输出: 1
 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 示例 3:

 输入: s = "pwwkew"
 输出: 3
 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @date: 2025/8/18 22:50
 * @author: dd
 */
public class Main_3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        int rightIndex = 0;
        HashSet<String> sets = new HashSet<>();
        int max = -1;
        String currentCh = s.charAt(0) + "";
        for (int i = 0; i < s.length(); i++) {
            while (!sets.contains(currentCh)) {
                // 追加
                sets.add(currentCh);
                // 往右移动
                ++rightIndex;
                if (rightIndex >= s.length()) {
                    break;
                }
                currentCh = s.charAt(rightIndex) + "";
            }
            // 判断当前字符串长度
            max = Math.max(max, sets.size());
            // 移除节点，进入下一个节点
            sets.remove(s.charAt(i) + "");
        }
        return max;
    }
}
