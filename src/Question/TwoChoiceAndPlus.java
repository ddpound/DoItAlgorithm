package Question;


import java.util.ArrayList;
import java.util.Collections;

/**
 * 프로그래머스 두개 뽑아서 더하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/68644
 *
 * 아이디어
 *
 * 1. 제한사항은 numbers의 최대 길이가 100이다. 효율성은 필요없다는 의미
 * 2. 수도 마찬가지 간단하게 경의 수로 구하면 된다.
 * 3. 2중 포문으로 돌려서 더한 값들을 모드 배열에 저장하자
 * 4. 그걸 내부 함수로 정렬을 하도록 하자
 * */
public class TwoChoiceAndPlus {


    public static void main(String[] args) {

    }

    public static int[] solution(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 1; j < numbers.length; j++) {
                if (!list.contains(numbers[i] + numbers[j]) && i != j) {
                    list.add(numbers[i] + numbers[j]);
                }
            }
        }

        // 정렬
        Collections.sort(list);
        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

}
