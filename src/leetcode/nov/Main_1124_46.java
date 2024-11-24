package leetcode.nov;

import java.util.ArrayList;
import java.util.List;

/**
 * 46.全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 * @date: 2024/11/24 17:03
 * @author: dayue
 */
public class Main_1124_46 {
    public static void main(String[] args) {
        List<List<Integer>> permute = permute(new int[]{1});
        permute.forEach(System.out::println);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> all = new ArrayList<>();
        dfs(all, null, nums);
        return all;
    }

    public static void dfs(List<List<Integer>> all, List<Integer> current, int[] nums) {
        if (current == null) {
            current = new ArrayList<>();
        }
        if (current.size() == nums.length) {
            List<Integer> item = new ArrayList<>(current);
            all.add(item);
            return;
        }
        for (int currentNum : nums) {
            if (current.contains(currentNum)) {
                continue;
            }
            current.add(currentNum);
            dfs(all, current, nums);
            current.remove(new Integer(currentNum));
        }
    }
}
