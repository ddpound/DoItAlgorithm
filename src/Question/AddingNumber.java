package Question;

import java.util.HashMap;

// 코테 없는 숫자 더하기
// https://school.programmers.co.kr/learn/courses/30/lessons/86051
public class AddingNumber {


    public static void main(String[] args) {
        int[] input = {1,2,3,4,6,7,8,0};

        System.out.println(solution(input));

    }


    public static int solution(int[] numbers) {
        int answer = 0;
        int[] checkList = {0,1,2,3,4,5,6,7,8,9};



        HashMap<Integer, Integer> checkNumber = new HashMap<>();

        for (int number : numbers) {
            checkNumber.put(number, number);
        }

        for (int j : checkList) {

            if (!checkNumber.containsKey(j)) {
                answer += j;
            }

        }



        return answer;
    }


}
