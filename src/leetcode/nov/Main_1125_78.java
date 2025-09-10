package leetcode.nov;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 78.子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * @date: 2024/11/25 23:25
 * @author: dd
 */
public class Main_1125_78 {
    public static void main(String[] args) {
        List<List<Integer>> subsets = subsets(new int[]{1, 2, 3});
        subsets.forEach(System.out::println);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> all = new ArrayList<>();
        // 避免重复计算
        Set<String> allList = new HashSet<>();
        for (int size = 1; size <= nums.length; size++) {
            dfs(allList, all, null, nums, size);
        }
        all.add(new ArrayList<>());
        return all;
    }

    public static void dfs(Set<String> allList, List<List<Integer>> all, List<Integer> current, int[] nums, int size) {
        if (current == null) {
            current = new ArrayList<>();
        }
        // 满足，则判断all是否包含，若没包含，则加入
        if (current.size() == size) {
            String orderList = current.stream().sorted().map(String::valueOf).collect(Collectors.joining("-"));
            if (allList.contains(orderList)) {
                return;
            } else {
                allList.add(orderList);
                all.add(new ArrayList<>(current));
            }
        }
        // 剪支
        for (int i = current.size(); i < nums.length; i++) {
            int num = nums[i];
            if (current.contains(num)) {
                continue;
            }
            current.add(num);
            dfs(allList, all, current, nums, size);
            current.remove(new Integer(num));
        }
    }
}
