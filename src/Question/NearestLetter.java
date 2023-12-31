package Question;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 프로그래머스 :  가장 가까운 글자
 *
 * */
public class NearestLetter {

    public static void main(String[] args) {
        System.out.println(solution("foobar"));
    }

    public static int[] solution(String s) {
        HashMap<Character, Character> stack = new HashMap<>();
        ArrayList<Integer> resultList = new ArrayList<Integer>();

        for (char c : s.toCharArray()
             ) {
            if(stack.isEmpty()){
                stack.put(c,c);
                resultList.add(-1);
            }else if(stack.containsKey(c)){
                resultList.add(2);
            }else{
                stack.put(c,c);
                resultList.add(-1);
            }
        }

        int[] answer = new int[resultList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = resultList.get(i);
        }

        for (int i = 0; i < resultList.size(); i++) {
            System.out.println(resultList.get(i));
        }

        return answer;
    }
}
