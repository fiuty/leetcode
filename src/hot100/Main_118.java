package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 118. 杨辉三角
 *
 * @date: 2025/9/24 22:27
 * @author: dd
 */
public class Main_118 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> all = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        for (int i = 0;i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            // 取出上一个集合
            if (i != 0) {
                pre = all.get(i - 1);
            }
            for (int j = 0; j <= i; j++) {
                // 如果为第一个或者最后一个，则填充为1
                if (j == 0 || j == i) {
                    temp.add(1);
                    continue;
                }
                // f(n,i) = f(n-1,i-1) + f(n-1,i)
                int current = pre.get(j - 1) + pre.get(j);
                temp.add(current);
            }
            all.add(temp);
        }
        return all;
    }
}
