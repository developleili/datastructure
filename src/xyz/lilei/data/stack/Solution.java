package xyz.lilei.data.stack;



/**
 * @ClassName Solution
 * @Description TODO
 * @Author lilei
 * @Date 16/06/2019 22:07
 * @Version 1.0
 **/
public class Solution {

    public boolean isValid(String s) {
            ArrayStack<Character> stack = new ArrayStack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '[' || c == '{')
                    stack.push(c);
                else {
                    if (stack.isEmpty())
                        return false;
                    char topChar = stack.pop();
                    if (c == ')' && topChar != '(')
                        return false;
                    if (c == ']' && topChar != '[')
                        return false;
                    if (c == '}' && topChar != '{')
                        return false;
                }
            }
            return stack.isEmpty();
    }
}
