package Question;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// https://school.programmers.co.kr/learn/courses/30/lessons/12906
// 프로그래머스 같은 숫자는 싫어

public class SameNumberHate {
    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};

        for (int i : solution(arr)
             ) {
            System.out.print(i + " ");
        }
    }

    public static int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        int[] reusult;


        for (int i : arr
             ) {
            if(stack.isEmpty()){
                System.out.println("push");
                stack.push(i);
            }else if (stack.peek() != i ) {
                System.out.println("push");
                stack.push(i);
            }
        }

        reusult = new int[stack.size()];
        for (int i = reusult.length-1; i >= 0; i--) {
            //System.out.println(stack.pop());
            reusult[i] = stack.pop();
        }
        System.out.println();
        return reusult;
    }
}
