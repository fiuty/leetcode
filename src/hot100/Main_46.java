package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列

 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。

 示例 1：

 输入：nums = [1,2,3]
 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 示例 2：

 输入：nums = [0,1]
 输出：[[0,1],[1,0]]
 示例 3：

 输入：nums = [1]
 输出：[[1]]

 * @date: 2025/8/20 23:54
 * @author: dd
 */
public class Main_46 {
    public static void main(String[] args) {
        List<List<Integer>> permute = permute(new int[]{0, 1});
        permute.forEach(item -> {
            item.forEach(subItem -> System.out.print(subItem + " "));
            System.out.println();
        });
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<String> temp = new ArrayList<>();
        int[] visit = new int[nums.length];
        List<List<Integer>> all = new ArrayList<>();
        dfs(nums, visit, temp, all);
        return all;
    }

    public static void dfs(int[] nums, int[] visit, List<String> temp, List<List<Integer>> all) {
        if (temp.size() == nums.length) {
            List<Integer> copy = new ArrayList<>();
            temp.forEach(item -> copy.add(Integer.parseInt(item)));
            all.add(copy);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visit[i] == 0) {
                visit[i] = 1;
                String numStr = nums[i] + "";
                temp.add(numStr);
                dfs(nums, visit, temp, all);
                visit[i] = 0;
                temp.remove(numStr);
            }
        }
    }
}
