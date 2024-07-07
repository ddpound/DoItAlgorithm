package Question;

import java.util.HashMap;

/**
 * 프로그래머스 숫자 문자열과 영단어
 * https://school.programmers.co.kr/learn/courses/30/lessons/81301
 *
 * */
public class NumberAndString {


    public static void main(String[] args) {
        System.out.println(solution("one4seveneight"));
        System.out.println(solution("23four5six7"));
    }


    public static int solution(String s) {
        int answer = 0;
        StringBuilder answerString = new StringBuilder(); // 반환 할때 변경해줄 예정


        HashMap<String, String> map = new HashMap<>();
        String stackString = "";
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");


        // 문자열 스택 하나씩 쌓을때마다 hashmap 에 검색 시도 값이 있으면 숫자 반환
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if(Character.isDigit(c)){
                answerString.append(c);
            }else{
                stackString += s.charAt(i);
            }

            // 모든 글자의 최대 수를 넘었을 때 검사 진행
            if(stackString.length() > 2){
                String mapData = map.get(stackString);

                if(mapData != null){
                    // 값이 있어서 반환하면 정답에 붙여준후 값 비우기
                    answerString.append(mapData);
                    stackString = "";
                }
            }

        }

        answer = Integer.parseInt(answerString.toString());

        return answer;
    }

}
