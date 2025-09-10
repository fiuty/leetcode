package hot100;

/**
 * 35. 搜索插入位置
 *
 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * @date: 2025/9/10 22:33
 * @author: dd
 */
public class Main_356 {
    public static void main(String[] args) {
        int[] nums = {3};
        System.out.println(searchInsert(nums, 5));
        System.out.println(searchInsert(nums, 2));
        System.out.println(searchInsert(nums, 7));
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = (right + left) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        while (left < right && nums[mid] != target) {
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = (left + right) / 2;
        }
        if (nums[mid] >= target) {
            return mid;
        }
        return mid + 1;
    }
}
