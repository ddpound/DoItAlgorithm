package Question;

import java.util.Arrays;
import java.util.HashMap;

public class MemoryScore {


    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}} ;

        System.out.println(Arrays.toString(solution(name, yearning, photo)));
    }

    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        HashMap<String, Integer> nameYearning = new HashMap<>();
        HashMap<String, Integer> nameYearningScore = new HashMap<>();


        for(int i =0; i < name.length; i ++){
           nameYearning.put(name[i] , yearning[i]);

        }

        for(int i =0; i < photo.length; i ++){
            nameYearningScore.put(name[i], 0);
        }

        int i = 0;

        for (String[] strings : photo) {
            int total = 0;
            for (String string : strings) {

                if(nameYearning.containsKey(string)){

                    total += nameYearning.get(string);
                }

            }
            answer[i] = total;
            i++;
        }


        return answer;
    }

}
