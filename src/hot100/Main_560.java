package hot100;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 560. 和为 K 的子数组
 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 子数组是数组中元素的连续非空序列。

 示例 1：
 输入：nums = [1,1,1], k = 2
 输出：2

 示例 2：
 输入：nums = [1,2,3], k = 3
 输出：2
 *
 * @date: 2025/9/20 12:20
 * @author: dd
 */
public class Main_560 {
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1};
        int[] nums2 = {1, 2, 3};
        System.out.println(subarraySum(nums1, 2));
        System.out.println(subarraySum(nums2, 3));
        int[] num3 = {1, 5, 4, 2, 1, 3, 2, 6};
        System.out.println(subarraySum(num3, 6));
        System.out.println("-----");
        System.out.println(subarraySum2(nums1, 2));
        System.out.println(subarraySum2(nums2, 3));
        System.out.println(subarraySum2(num3, 6));
    }

    public static int subarraySum(int[] nums, int k) {
        // 暴力破解，双重循环
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (temp == k) {
                ++count;
            }
            for (int j = i + 1; j < nums.length; j++) {
                temp += nums[j];
                if (temp == k) {
                    ++count;
                }
            }
        }
        return count;
    }

    /*
    1.利用map存储前缀和，前缀和 pre[i] 是数组中从第一个元素到第 i 个元素的总和
    2.利用前缀和pre[i] - k = x，判断x是否在前缀和中，如果在，则存在k合
     */
    public static int subarraySum2(int[] nums, int k) {
        return 0;
    }
}
