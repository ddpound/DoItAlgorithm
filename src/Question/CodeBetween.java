package Question;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 코딩테스트
 * 둘만의 암호
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/155652
 *
 * 97 부터가 a
 * 122 까지가 z
 *
 * */
public class CodeBetween {

    public static void main(String[] args) {
        String s = "aukks";
        String skip ="wbqd";
        int index = 5;

        System.out.println(solution(s,skip,index));
    }

    public static String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();


        for (int i = 0; i < s.length(); i++) {
            char returnChar = s.charAt(i);

            for (int j = 0; j < index; j++) {

                returnChar += 1;

                // 여길 먼저 빼줘야함....
                // 더하고 체크하기전에 먼저 z가 넘는지 않넘는지를 파악해야함
                if(returnChar > 'z'){
                    returnChar -= 26;
                }

                if(skip.contains(String.valueOf(returnChar))) {
                    j--;
                }

                System.out.println("중간 : " +returnChar);
            }

            System.out.println("최종 : " +returnChar);
            System.out.println("----------------------------------");
            answer.append(returnChar);

        }


        return answer.toString();
    }
}
