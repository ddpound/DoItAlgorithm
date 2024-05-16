package Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class RoughKeyboard {


    public static void main(String[] args) {
        String[] keymap = {"ABACD", "BCEFD"};
        String[] target = {"ABCD","AABB"};

        System.out.println(Arrays.toString(solution(keymap, target)));

        String[] keymap1 = {"AA"};
        String[] target1 = {"AB"};

        System.out.println(Arrays.toString(solution(keymap1, target1)));

        String[] keymap2 = {"ABCDE", "FGHIJ"};
        String[] target2 = {"ZABCDE"};

        System.out.println(Arrays.toString(solution(keymap2, target2)));

    }

    public static int[] solution(String[] keymap, String[] targets) {
        ArrayList<Integer> newAnswer = new ArrayList<>();

        HashMap<Character, Integer> numberDoc = new HashMap<>();

        for (String key : keymap){
            for (int i = 0; i < key.length(); i++) {
                Character newKey = key.charAt(i);
                if(numberDoc.containsKey(newKey)){
                    if(numberDoc.get(newKey) > i){
                        numberDoc.put(newKey,i+1);
                    }
                }else{
                    numberDoc.put(newKey,i+1);
                }
            }
        }

        for(String target : targets){
            char[] tList = target.toCharArray();
            int sum = 0;

            for (char t : tList){
                if(numberDoc.containsKey(t)){
                    sum += numberDoc.get(t);
                }else{
                    sum = -1;
                    break;
                }
            }

            newAnswer.add(sum);
        }

        int[] answer = new int[newAnswer.size()];
        for (int i = 0; i < newAnswer.size(); i++) {
            answer[i] = newAnswer.get(i);
        }

        return answer;
    }

}
