package hot100;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号
 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

 有效字符串需满足：

 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。
 每个右括号都有一个对应的相同类型的左括号。

 输入：s = "()"
 输出：true

 输入：s = "()[]{}"
 输出：true

 输入：s = "(]"
 输出：false

 *
 * @date: 2025/9/13 22:48
 * @author: dd
 */
public class Main_20 {
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        stack.add(s.charAt(0));
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        for (int i = 1; i < s.length(); i++) {
            Character current = s.charAt(i);
            if (stack.isEmpty()) {
                stack.add(current);
                continue;
            }
            Character pop = stack.pop();
            Character need = map.get(pop);
            if (need != current) {
                stack.add(pop);
                stack.add(current);
            }
        }
        return stack.isEmpty();
    }
}
