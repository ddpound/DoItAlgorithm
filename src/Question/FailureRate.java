package Question;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 프로그래머스 문제 실패율
 * https://school.programmers.co.kr/learn/courses/30/lessons/42889
 *
 * 아이디어
 * 1. 도달카운트 keymap 과 도달하지 못한 keymap을 만들어 스택처럼 쌓아나갈 예정입니다.
 * 2. 각각의 도달 인자 key값 - 도달하지못한 key 값을 하면 클리어 하지 못한 값이 나옵니다
 * 3. 클리어하지못한 값 / 도달한 값 을 나누면 실패율이 됩니다
 * 4. 실패율을 순서대로 담아내서 value에 넣고
 * 5. 스테이지또한 value2에 담아서 내림차순으로 같이 진행하면 원하는 값이 나옵니다.
 * 6. 여기서 중요한점 실패율은 내림차순이고 비교대상이 같은 스테이지는 스테이지 번호의 오름차순으로 진행된다
 * 7. quick sort 진행할때 만약 피벗과 값이 같다면 스테이지를 비교해서 스테이지가 더 낮으면 앞으로 보내면 될것이다.
 *
 *
 * 1. 1차적인 목표는 일단 valuelist와 stagelist를 추출하는것
 * 2. 정렬 방법 생각하는것
 *
 * */
public class FailureRate {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
        System.out.println(Arrays.toString(solution(4, new int[]{4,4,4,4,4})));
    }

    public static int[] solution(int N, int[] stages) {
        HashMap<Integer,Integer> goalMap = new HashMap<>(); // 도달한 keymap
        HashMap<Integer,Integer> notGoalMap = new HashMap<>();

        for (int i : stages){
            // j 가 1까지 도달할 때
            for (int j = i; j > 0; j--) {
                putMap(goalMap , j);
            }

            // 도달하지 못한자
            for (int j = i-1; j > 0; j--) {
                putMap(notGoalMap, j);
            }
        }

        System.out.println(goalMap);
        System.out.println(notGoalMap);

        int[] stageList = new int[goalMap.size()];
        double[] valueList = new double[goalMap.size()+1];

        // goalmap 이 기준이며 만약 goalMap은 있는데 notGoalMap에 없으면 0으로 입력해서 넣는다
        for (Map.Entry<Integer, Integer> entry : goalMap.entrySet()) {

            if(notGoalMap.get(entry.getKey()) == null){
                valueList[entry.getKey()] = 0;
            }else{
                valueList[entry.getKey()] = (double) goalMap.get(entry.getKey()) / (double) (goalMap.get(entry.getKey())-notGoalMap.get(entry.getKey()));
            }

            System.out.println( (goalMap.get(entry.getKey()) - (notGoalMap.get(entry.getKey()) == null ? 0 : notGoalMap.get(entry.getKey()))) + " / " + goalMap.get(entry.getKey()) );
        }

        System.out.println(Arrays.toString(valueList));

        int[] answer = new int[stages.length];
        return answer;
    }

    public static void putMap(HashMap<Integer,Integer> putmap, int i){
        if(putmap.isEmpty()){
            putmap.put(i , 1);
        } else if (putmap.containsKey(i)) {
            putmap.put(i, putmap.get(i) + 1);
        } else {
            putmap.put(i, 1);
        }
    }
}
