package Question;

import java.util.Stack;

// 프로그래머스 올바른 괄호
// https://school.programmers.co.kr/learn/courses/30/lessons/12909
public class GoodBracket {

    public static void main(String[] args) {

    }

    public static boolean solution(String s) {
        boolean answer = false;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }else{
                if(stack.peek() == '(' && s.charAt(i) == ')'){
                    stack.pop();
                }else{
                    stack.push(s.charAt(i));
                }
            }

        }

        if(stack.isEmpty()) answer = true;

        return answer;
    }
}
