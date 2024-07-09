package Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/** *
 * 완주하지 못한 선수
 * https://school.programmers.co.kr/learn/courses/30/lessons/42576
 *
 * 아이디어
 * 1. HashMap 을 사용하되 중복요소가 있을 수 있음 -> 그래서 요소를 스택으로 해서 만들어두자
 * 2. Hash로 명단을 key로 담아두고 중복된 수는 value에 개수로 담아둡니다.
 */

public class NotFinishRunner {

    public static void main(String[] args) {

    }


    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> participantMap = new HashMap<>();

        for (String i : participant){
            if(participantMap.isEmpty()){
                participantMap.put(i, 1);
            }else if(participantMap.containsKey(i)){
                participantMap.put(i , participantMap.get(i)+1);
            }else{
                participantMap.put(i , 1);
            }
        }

        for (String i : completion){
            if(participantMap.containsKey(i)){
                if(participantMap.get(i) > 1){
                    participantMap.put(i , participantMap.get(i)-1);
                }else{
                    // 값이 있는데 1이면 완전삭제
                    participantMap.remove(i);
                }
            }
        }
        // Entry 리스트
        List<HashMap.Entry<String, Integer>> entryList = new ArrayList<>(participantMap.entrySet());

        for (HashMap.Entry<String, Integer> entry : entryList) {
           answer = entry.getKey();
        }

        return answer;
    }



}
