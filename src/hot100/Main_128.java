package hot100;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 最长连续序列
 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 示例 1：

 输入：nums = [100,4,200,1,3,2]
 输出：4
 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 示例 2：

 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 输出：9
 示例 3：

 输入：nums = [1,0,1,2]
 输出：3
 *
 * @date: 2025/8/10 12:30
 * @author: dd
 */
public class Main_128 {
    public static void main(String[] args) {
        int [] nums = {100,4,200,1,3,2};
        longestConsecutive(nums);
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        // 去重，并排序
        List<Integer> numbers = Arrays.stream(nums).distinct().sorted().boxed().collect(Collectors.toList());
        int max = 0;
        int tempMax = 1;
        for (int currentIndex = 0, nextIndex = 1; currentIndex < numbers.size() - 1 && nextIndex < numbers.size();
             currentIndex++, nextIndex++) {
            Integer currentNum = numbers.get(currentIndex);
            Integer nextNum = numbers.get(nextIndex);
            // 连续
            if (currentNum != nextNum && nextNum - currentNum == 1) {
                ++tempMax;
            } else {
                if (max < tempMax) {
                    max = tempMax;
                }
                tempMax = 1;
            }
        }
        return Math.max(tempMax, max);
    }
}
