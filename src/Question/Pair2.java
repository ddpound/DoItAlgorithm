package Question;

// https://school.programmers.co.kr/learn/courses/30/lessons/12973
// 짝지어 제거하기


import java.util.ArrayList;
import java.util.Stack;

public class Pair2 {

    // 기존 문제풀이를 토대로 새롭게 풀기 위한 풀이
    // 다 돌릴 필요가 없네..? 그냥 일부분만 찾아내서 1 과 0 출력
    public static void main(String[] args) {
        System.out.println(solution("baaaaaaaaaacccceeeebccdd"));
    }

    public static int solution(String s)
    {
        int answer = -1;
        Stack<Character> stack  = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }else{
                if(s.charAt(i) == stack.peek()){
                    stack.pop();
                }else{
                    stack.push(s.charAt(i));
                }
            }
        }

        if(stack.isEmpty()){
            answer = 1;
        }else{
            answer = 0;
        }

        return answer;
    }

}
