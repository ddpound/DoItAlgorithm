package Question;

import java.util.ArrayList;

public class SameNumberHate {
    public static void main(String[] args) {

    }


    public static int[] solution(int []arr) {
        ArrayList<Integer> copyList = new ArrayList<>();

        // 깃 푸시 테스트
        int number = arr[0];
        for (int j : arr) {
            if (number < 0) {
                number = j;
            }
            if (j != number) {
                copyList.add(number);
                number = -1;
            }
        }
        int[] answer = new int[copyList.size()];
        for (int i = 0; i < copyList.size(); i++) {
            answer[i] = copyList.get(i);
        }

        return answer;
    }

}
