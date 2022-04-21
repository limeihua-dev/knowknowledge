package com.amei.knowledge.算法题;

import java.util.Stack;

public class 有效括号 {

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i =0 ;i<s.length();i++){
            char cur = s.charAt(i);
            if (cur== '('){
                stack.push(')');
            }else if(cur== '['){
                stack.push(']');
            }else if(cur== '{'){
                stack.push('}');
            }else if (stack.isEmpty()||cur!=stack.pop()){
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(]";
        isValid(s);
    }
}
