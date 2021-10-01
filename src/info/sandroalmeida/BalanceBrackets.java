package info.sandroalmeida;

import java.util.Stack;

public class BalanceBrackets {

    public static boolean isBalanced(String s) {

        if(s.equals("")) return true;

        Stack<String> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(char c: chars) {
            if (c == '(' || c == '{' || c == '['){
                stack.add(c + "");
            } else{
                if (c ==')'){
                    if(stack.peek().equals("("))
                        stack.pop();
                    else
                        return false;
                } else if (c =='}') {
                    if (stack.peek().equals("{"))
                        stack.pop();
                    else
                        return false;
                } else if(c ==']') {
                    if (stack.peek().equals("["))
                        stack.pop();
                    else
                        return false;
                }
            }
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        String s_1 = "{[(])}";
        //boolean expected_1 = false;
        System.out.println(isBalanced(s_1));

        String s_2 = "{{[[(())]]}}";
        //boolean expected_2 = true;
        System.out.println(isBalanced(s_2));
    }
}
