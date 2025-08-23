package hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字母异位词分组
 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。

 示例 1:
 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 解释：

 在 strs 中没有字符串可以通过重新排列来形成 "bat"。
 字符串 "nat" 和 "tan" 是字母异位词，因为它们可以重新排列以形成彼此。
 字符串 "ate" ，"eat" 和 "tea" 是字母异位词，因为它们可以重新排列以形成彼此。
 示例 2:

 输入: strs = [""]

 输出: [[""]]

 示例 3:

 输入: strs = ["a"]

 输出: [["a"]]
 * @date: 2025/8/9 22:31
 * @author: dd
 */
public class Main_49 {
    static String lowercase = "qwertyuiopasdfghjklzxcvbnm";

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> list = new ArrayList<>();
        if (strs.length == 0) {
            List<String> item = new ArrayList<>();
            list.add(item);
            return list;
        }
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            String key = handleIndex(str);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                ArrayList<String> groupList = new ArrayList<>();
                groupList.add(str);
                map.put(key, groupList);
            }
        }
        for (List<String> value : map.values()) {
            list.add(value);
        }
        return list;
    }

    public static String handleIndex(String str) {
        int[] temp = new int[130];
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i);
            ++temp[index];
        }
        StringBuilder indexKey = new StringBuilder();
        for (int i = 0; i < lowercase.length(); i++) {
            int index = lowercase.charAt(i);
            int count = temp[index];
            if (count != 0) {
                indexKey.append(index).append(count);
            }
        }
        return indexKey.toString();
    }
}
