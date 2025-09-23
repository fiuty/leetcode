package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 53. 最大子数组和
 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 子数组是数组中的一个连续部分。

 示例 1：

 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 输出：6
 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 示例 2：

 输入：nums = [1]
 输出：1
 示例 3：

 输入：nums = [5,4,-1,7,8]
 输出：23
 *
 * @date: 2025/9/22 23:00
 * @author: dd
 */
public class Main_53 {
    public static void main(String[] args) {
        int[] nums = {5,4,-1,7,8};
        System.out.println(maxSubArray(nums));
    }

    /*
    1.f(i)表示下标i的 连续子数组的最大和
    2.f(i) = max {f(i-1), f(i-1) + num[i]}
     */
    public static int maxSubArray(int[] nums) {
        int pre = 0;
        List<Integer> maxI = new ArrayList<>();
        for (int num : nums) {
            pre = Math.max(num, pre + num);
            maxI.add(pre);
        }
        int max = maxI.get(0);
        for (Integer num : maxI) {
            max = Math.max(max, num);
        }
        return max;
    }
}
