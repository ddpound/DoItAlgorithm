package Question;

import java.util.Arrays;
import java.util.Stack;

/**
 * 프로그래머스 명예의 전당
 * https://school.programmers.co.kr/learn/courses/30/lessons/138477
 *
 * 아이디어
 * 1. 일단 답변할 리스트는 스택이 맞음
 * 2. 그럼 다꺼내놓을 임시 스택이 필요함
 *
 * 풀이
 * 1. 스택이 총 두개가 필요함
 * 2. A 스택이 답변으로 낼 스택이고 B 스택이 A 값을 꺼내면 담아둘 저장소
 * 3. A 스택으로 담음, 가장 위에 값을 꺼내보고 지금 넣을 값이 더 크다면 넣을 값 x를 넣은 후 꺼내본 값을 넣어 스위칭
 * 4. 반복 하다가 스택이 k 용량에 도달하면 맨 위의 값 pop
 * 5. 만약 맨위 값 x 가 있고 새로 넣을값 y 가 있을때 x를 꺼내고 y 가 더크다면 x pop을 하고 다음 값 z 를 pop 해서 비교 3번 반복
 * */
public class TheHallOfFame1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, new int[]{10, 100, 20, 150, 1, 100, 200})));
        System.out.println(Arrays.toString(solution(4, new int[]{1000, 300, 40, 300, 20, 70, 150, 50, 500, 1000})));
    }

    public static int[] solution(int k, int[] score){

        // 스택은 신기하게 pop 등의 스택 자료구조를 따라가지만 index로 편리하게 접근도 가능합니다.
        Stack<Integer> resultStack = new Stack<>();
        Stack<Integer> tempStack = new Stack<>(); // 임시 스택
        int[] result = new int[score.length];
        int index = 0;

        for(int i : score){
            if(resultStack.isEmpty()){
                resultStack.push(i);
            }else {
                while (!resultStack.isEmpty()){
                    int tempInt = resultStack.pop();
                    if(tempInt < i){
                        tempStack.push(tempInt);
                    } else {
                        resultStack.push(tempInt);
                        if(resultStack.size() < k) {
                            resultStack.push(i);
                            while (!tempStack.isEmpty()){
                                resultStack.push(tempStack.pop());
                            }
                        }
                        break;
                    }
                }

                if(!tempStack.isEmpty()){
                    resultStack.push(i);
                    while (!tempStack.isEmpty()){
                        resultStack.push(tempStack.pop());
                    }
                }

            }
            if(resultStack.size() > k) {
                resultStack.pop();
            }
            //System.out.println(resultStack);
            result[index] = resultStack.peek(); // pop 이 아닌 맨 마지막 값만 참조
            index++;
        }


        return result;
    }

}
