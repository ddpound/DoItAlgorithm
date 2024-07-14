package Question;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 프로그래머스 이진 변환 반복하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/70129
 *
 * 아이디어
 * 1. while로 반복하면됨 무조건 1 하나 남음
 * 2. 배열을 순차 배열로 돌면서 0을 제거 제거하면서 int로 개수 올리기
 * 3. 순서대로 돌려가며 0을 제거
 * 4. 0이 제거된 1의 길이를 이진법으로 변환
 * 5. 2진법으로 변환된 문자열을 다시 반복
 * 6. 이 회차가 돌때마다 1
 * */
public class BinaryRepeat {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("110010101001")));
    }

    /**
     * @return [총 반복한 회차, 제거된 0의 개수]
     * */
    public static int[] solution(String s) {

        int zeroCount = 0;
        int loopCount = 0;
        ArrayList<Character> characters;

        while (!s.equals("1")){
            characters = new ArrayList<>();
            // 0 제거 공정
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '1'){
                    characters.add(s.charAt(i));
                }else{
                    zeroCount++;
                }
            }

            // 남은 길이
            s = Integer.toBinaryString(characters.size());
            System.out.println("값 체크 : " + s);

            if(s.equals("1")){
                loopCount++;
                break;
            }else{
                loopCount++;
            }
        }

        return new int[]{loopCount , zeroCount};
    }

}
