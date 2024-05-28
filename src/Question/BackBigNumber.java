package Question;

import java.util.*;

/**
 * 프로그래머스 : 뒤에있는 큰수 찾기
 *
 *
 * 1차 아이디어
 * 1. HashMap으로 번호, 인덱스를 저장
 * 2. 해당 번호가 나오면 저장된 값으로 현재 인덱스를 여전히 초과하지 않으면 값을 넣어주기
 *
 * 2차 아이디어
 * 1. 일단 정렬해서
 * */
public class BackBigNumber {

    public static void main(String[] args) {
        // 1,2,3,5,6,9
        // 1,5,3,2,4,0

        // 9,6,5,3,2,1
        int[] insertData1 = {9, 1, 5, 3, 6, 2};
        System.out.println(Arrays.toString(solution(insertData1)));

        // 5,3,3,2
        // 5,3,3,2
        int[] insertData2 = {2,3,3,5};
        System.out.println(Arrays.toString(solution(insertData2)));

        // 거꾸로 반복
        // 6,5,2를 담고 3차례이면 6,5,3, 으로 바꿔줌
        // 바뀐 애들은 바뀐 값을 저장해줌 boolean 으로
        // 안바뀐 인덱스만 넣어두기

        int[] insertData3 = {6,5,2,3,1,5,1,2,3,45,6,7,83,40,50,402,10,20,33,44,52,65,77,30,23};
        System.out.println(Arrays.toString(solution(insertData3)));

        int[] insertData5 = {6,5,2,3,1,5,1,2,3,45,6,7,83,40,50,402,10,20,33,44,52,65,77,30,23};
        //System.out.println(Arrays.toString(insertData5));
        System.out.println(Arrays.toString(solution2(insertData5)));

        // 2(3),3,4,5,5,6(0),7(6),12(4)
        int[] insertData4 = {6,5,4,2,12,3,7,5};
        System.out.println(Arrays.toString(solution(insertData4)));


        int[] insertData6 = {6,5,2,3,1,5,1,2,3,45,6,7,83,40,50,90,402,10,20,33,44,52,65,77,30,23};
        System.out.println(Arrays.toString(solution(insertData6)));

        int[] insertData7 = {6,5,2,3,1,5,1,2,3,45,6,7,83,40,50,90,402,10,20,33,44,52,65,77,30,23};
        System.out.println(Arrays.toString(solution3(insertData7)));

        System.out.println(Arrays.toString(solution(insertData1)));
        System.out.println(Arrays.toString(solution3(insertData1)));

    }

    public static int[] solution(int[] numbers) {

        ArrayList<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < numbers.length; i ++) {
            boolean find = false;
            for (int j = i+1; j < numbers.length; j++) {
                // 특정 조건을 만족하면 break 걸기
                if (numbers[i] < numbers[j]) {
                    resultList.add(numbers[j]);
                    find = true;
                    break;
                }
            }

            if (!find) resultList.add(-1);
        }

        int[] answer = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            answer[i] = resultList.get(i);
        }

        return answer;
    }


    // 시간 복잡도 해결 시도1
    // 일단 큰숫자를 뒤로 미루는 것부터가 가장 좋은 방법임 반복횟수를 줄일수 있음
    public static int[] solution2(int[] numbers) {

        Stack<Integer> notChangeIndexStack = new Stack<>(); // 안바뀐 리스트 남겨두는 스택

        // {6,5,2,3,1,5,1,2,3,45,6,7,83,40,50,402,10,20,33,44,52,65,77,30,23}
        // 0,1,2
        for (int i = 0; i < numbers.length; i ++) {

            int wonSize = notChangeIndexStack.size();

            // 스택 한번 다 비우기
            for (int j = 0; j < wonSize; j++) {
                int popIndex = notChangeIndexStack.pop();

                if(numbers[popIndex] < numbers[i]){
                    numbers[popIndex] = numbers[i];
                }else{
                    // 다시 넣기
                    notChangeIndexStack.push(popIndex);
                }
            }

            notChangeIndexStack.push(i);
        }

        int wonSize = notChangeIndexStack.size();
        // 남은 애들은 다 -1
        for (int j = 0; j < wonSize; j++) {
            numbers[ notChangeIndexStack.pop()] = -1;
        }

        return numbers;
    }

    // 시간복잡도는 조금 해결했는데 답을 못찾음
    public static int[] solution3(int[] numbers) {

        // 그냥 다 스택으로 넣는거네?
        // 스택으로 다 넣어버리고 하나씩 꺼내서 비교하면됨
        // 문제 자체가 스택문제였던거임...
        Stack<Integer> stack = new Stack<>();

        int maxNumber = 0; // 최고 숫자는 항상 저장해두어야 함 바로 -1 처리를 위해서

        // {6,5,2,3,1,5,1,2,3,45,6,7,83,40,50,90,402,10,20,33,44,52,65,77,30,23}
        // 0,1,2
        for (int i = numbers.length - 1; i >= 0 ; i--) {
            if(maxNumber == 0){
                maxNumber = numbers[i]; // maxnumber 처리
                numbers[i] = -1;
            } else if (maxNumber < numbers[i]) {
                maxNumber = numbers[i]; // maxnumber 처리
                stack.clear();
                stack.push(numbers[i]);
                numbers[i] = -1;
            } else{
                for (int j = stack.size()-1; j >= 0; j--) {
                    if(stack.get(j) > numbers[i]){
                        int temp = stack.get(j);
                        stack.push(numbers[i]);
                        numbers[i] = temp;
                        break;
                    }
                }
            }
        }
        return numbers;
    }

    // 도움을 받은 문제 풀이
    public static int[] solutionA(int[] numbers) {
        // number index 정보를 담을 Stack 생성
        Stack<Integer> stack = new Stack<>();

        // 정답 배열 생성
        int[] answer = new int[numbers.length];

        // 첫 번째 number 인덱스 stack에 push
        stack.push(0);

        // 두 번째 원소부터 numbers 탐색
        for (int i = 1; i < numbers.length; i++) {
            // 스택이 비어있지 않으면서 현재 스택이 바라보고 있는 값보다 number의 값이 크면 뒤에 있는 큰수 해당
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                // 뒤에 있는 큰 수에 해당하는 모든 값 pop
                answer[stack.pop()] = numbers[i];
            }
            // 현재 인덱스 push
            stack.push(i);
        }
        // 모든 index를 탐색 후 뒤에 있는 큰 수가 없는 경우 -1
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        return answer;
    }

}
