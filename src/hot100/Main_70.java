package hot100;

/**
 70. 爬楼梯
 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

 示例 1：

 输入：n = 2
 输出：2
 解释：有两种方法可以爬到楼顶。
 1. 1 阶 + 1 阶
 2. 2 阶
 示例 2：

 输入：n = 3
 输出：3
 解释：有三种方法可以爬到楼顶。
 1. 1 阶 + 1 阶 + 1 阶
 2. 1 阶 + 2 阶
 3. 2 阶 + 1 阶

 1 <= n <= 45
 * @date: 2025/9/23 21:49
 * @author: dd
 */
public class Main_70 {
    public static void main(String[] args) {

    }

    /*
    f(i) = f(i-1) + f(i-2)
    因为
    f(i-1) + 1 满足 步骤为i所需的场景
    f(i-2) + 2 满足 步骤为i所需的场景
    两者相加为f(i)的所有场景
     */
    public static int climbStairs(int n) {
        // 上上步
        int prePreNum = 1;
        // 上一步
        int preNum = 2;
        if (n == 1) {
            return prePreNum;
        }
        if (n == 2) {
            return preNum;
        }
        for (int i = 3; i <= n; i++) {
            // 当前n=i时，currentMethod种方法
            int currentMethod = prePreNum + preNum;
            prePreNum = preNum;
            preNum = currentMethod;
        }
        return preNum;
    }
}
