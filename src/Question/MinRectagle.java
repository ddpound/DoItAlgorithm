package Question;


// 프로그래머스, 최소 직사각형
// https://school.programmers.co.kr/learn/courses/30/lessons/86491


import java.util.ArrayList;
import java.util.Collections;

/**
 * 아이디어
 * 1. 일단 무조건 w,h 중 가장 큰 숫자는 구해야함.
 * 2. w,h 중 큰 수를 앞으로 변경 해줌. 배열을 두개로 하자
 * 3. w 배열, h 배열 두개로 하며 w 와 h 중 더 큰걸 w , 작은걸 h 로 넣는다.
 * 4. 두개의 배열을 정렬하여 가장 큰 값두개를 곱해주면 됩니다.
 * */
public class MinRectagle {

    public static void main(String[] args) {

    }

    public static int solution(int[][] sizes) {
        int answer = 0;
        ArrayList<Integer> widthList = new ArrayList<>();
        ArrayList<Integer> heightList = new ArrayList<>();

        for (int[] i : sizes){
            if (i[0] < i[1]){
                widthList.add(i[1]);
                heightList.add(i[0]);
            }else{
                widthList.add(i[0]);
                heightList.add(i[1]);
            }
        }

        widthList.sort(Collections.reverseOrder());
        heightList.sort(Collections.reverseOrder());

        answer = widthList.get(0) * heightList.get(0);

        return answer;
    }

}
