package Question;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 프로그래머스 :  가장 가까운 글자
 *
 * */
public class NearestLetter {

    public static void main(String[] args) {
        System.out.print(solution("foobar"));
    }

    public static int[] solution(String s) {
        HashMap<Character, Integer> stack = new HashMap<>();
        ArrayList<Integer> resultList = new ArrayList<Integer>();

        for (int i = 0; i < s.length(); i++) {
            if(stack.isEmpty()){
                stack.put(s.charAt(i),i);
                resultList.add(-1);
            }else if(stack.containsKey(s.charAt(i))){
                resultList.add(i-stack.get(s.charAt(i)));
                stack.put(s.charAt(i), i);
            }else{
                stack.put(s.charAt(i),i);
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
