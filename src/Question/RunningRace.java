package Question;

import java.util.HashMap;

/**
 * 프로그래머스 달리기 경주
 * https://school.programmers.co.kr/learn/courses/30/lessons/178871
 *
 * 아이디어
 * 1. Hash에 인덱스 번호 담아두고
 * 2. Hash 검색을 통해 인덱스를 바로 찾아내 교체 번호 확인 바로앞번호와 교체
 * 3. Hash맵에도 마찬가지로 업데이트 진행
 * */
public class RunningRace {

    public static void main(String[] args) {

    }

    public static String[] solution(String[] players, String[] callings) {

        HashMap<String, Integer> map = new HashMap<>();

        // HashMap 초기화 작업 진행
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        // callings 시작
        for (String s : callings){

            swap(players, map, map.get(s), map.get(s)-1);
        }


        String[] answer = players;
        return answer;
    }

    public static void swap(String[] players, HashMap<String,Integer> map , int changeIndex1, int changeIndex2 ){
        // 먼저 map 부터 업데이트
        map.put(players[changeIndex1] , changeIndex2);
        map.put(players[changeIndex2] , changeIndex1);

        String temp = players[changeIndex1];
        players[changeIndex1] = players[changeIndex2];
        players[changeIndex2] = temp;
    }

}
