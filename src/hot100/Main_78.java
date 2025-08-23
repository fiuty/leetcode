package hot100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 子集
 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 示例 1：

 输入：nums = [1,2,3]
 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 示例 2：

 输入：nums = [0]
 输出：[[],[0]]

 * @date: 2025/8/21 0:09
 * @author: dd
 */
public class Main_78 {
    public static Set<String> SET;

    public static void main(String[] args) {
        List<List<Integer>> subsets = subsets(new int[]{0});
        System.out.println(subsets.size());
        subsets.forEach(item -> {
            item.forEach(subItem -> System.out.print(subItem + " "));
            System.out.println();
        });
    }

    public static List<List<Integer>> subsets(int[] nums) {
        SET = new HashSet<>();
        List<List<Integer>> all = new ArrayList<>();
        int[] visit = new int[nums.length];
        List<String> temp = new ArrayList<>();
        dfs(all, nums, visit, temp);
        return all;
    }

    public static void dfs(List<List<Integer>> all, int[] nums, int[] visit, List<String> temp) {
        String sortNum = temp.stream().sorted().collect(Collectors.joining());
        if (!SET.contains(sortNum)) {
            List<Integer> items = temp.stream().map(Integer::parseInt).collect(Collectors.toList());
            all.add(items);
            SET.add(sortNum);
        }
        for (int i = 0; i < nums.length; i++) {
            if (visit[i] == 0) {
                String numStr = nums[i] + "";
                temp.add(numStr);
                visit[i] = 1;
                dfs(all, nums, visit, temp);
                visit[i] = 0;
                temp.remove(numStr);
            }
        }
    }
}
