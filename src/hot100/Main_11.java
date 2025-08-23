package hot100;

/**
 * 盛最多水的容器
 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。

 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

 返回容器可以储存的最大水量。

 说明：你不能倾斜容器。
 输入：[1,8,6,2,5,4,8,3,7]
 输出：49
 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 示例 2：

 输入：height = [1,1]
 输出：1
 *
 * @date: 2025/8/10 13:36
 * @author: dd
 */
public class Main_11 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));

        int[] height2 = {1,1};
        System.out.println(maxArea(height2));
    }

    // 两层for循环超时
    public static int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            int currentArea = 0;
            for (int j = i + 1; j < height.length; j++) {
                int left = height[i];
                int right = height[j];
                int minHeight = Math.min(left, right);
                int area = minHeight * (j - i);
                currentArea = Math.max(currentArea, area);
            }
            maxArea = Math.max(maxArea, currentArea);
        }
        return maxArea;
    }

    // 从左边开始遍历，每次遍历，计算面积从右边开始计算面积
    // 如果左边高度，乘以 当前 x 轴宽度，还小于当前迭代计算的面积，则终止，得出当前遍历最大面积
    // 特殊情况比如0，跳过
    public static int maxArea2(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            int currentMax = 0;
            int left = height[i];
            if (maxArea != 0 && left == 0) {
                continue;
            }
            for (int j = height.length - 1; j > i; j--) {
                int right = height[j];
                if (maxArea != 0 && right == 0) {
                    continue;
                }
                int currentMin = Math.min(left, right);
                int weight = j - i;
                int currentArea = weight * currentMin;
                currentMax = Math.max(currentArea, currentMax);
                if (left * weight < currentMax) {
                    break;
                }
            }
            maxArea = Math.max(maxArea, currentMax);
        }
        return maxArea;
    }

    // O(n)
    public static int answer(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = Math.min(height[left], height[right]) * (right - left);
        for (int i = 0; i < height.length; i++) {
            if (height[left] < height[right]) {
                ++left;
            } else {
                --right;
            }
            if (left == right) {
                break;
            }
            int currentMin = Math.min(height[left], height[right]);
            max = Math.max(max, currentMin * (right - left));
        }
        return max;
    }
}
