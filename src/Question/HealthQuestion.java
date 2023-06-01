package Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HealthQuestion {


    public static void main(String[] args) {

        String inputString = "aaaabbbccccaaaddGGFAAXXBBB";


        System.out.println(countChar(inputString));



    }

    public static String dis(String input){

        HashMap<Character, Character> check = new HashMap<>();
        StringBuilder returnString = new StringBuilder();

        HashMap<Character, Integer> countMap = new HashMap<Character, Integer>();

        for (int i = 0; i < input.length(); i++) {

            if(check.isEmpty()){
                check.put(input.charAt(i),input.charAt(i));
                
                returnString.append(input.charAt(i));
            }else{
                if(!check.containsKey(input.charAt(i))){
                    check.put(input.charAt(i),input.charAt(i));
                    returnString.append(input.charAt(i));
                }
            }

        }


        for (int i = 0; i < input.length(); i++) {
            if(countMap.isEmpty()){
                countMap.put(input.charAt(i),1);
            }else {
                if(countMap.containsKey(input.charAt(i))){
                    countMap.put(input.charAt(i), countMap.get(input.charAt(i))+1);
                }else{
                    countMap.put(input.charAt(i),1);
                }
            }
        }

        int maxCount = 0;
        char maxChar = 'a';
        for (Map.Entry<Character, Integer> entrySet : countMap.entrySet()) {
            System.out.println(entrySet.getKey() + " : " + entrySet.getValue());



            if(maxCount < entrySet.getValue()){
                maxCount = entrySet.getValue();
                maxChar = entrySet.getKey();
            }

        }

        System.out.println("가장 많이반복되는 문자는 :  " + maxChar);
        System.out.println("가장 많이반복되는 문자의 갯수 :  " + maxCount);

        // 중복 제거 봔환
        return returnString.toString();
        // 한번의 메소드에 가장 많이 반복되는 문자와 문자 갯수, 그리고 중복제거까지 모두 완료했습니다!
    }


    public static char countChar(String input){

        HashMap<Character, Character> check = new HashMap<>();
        StringBuilder returnString = new StringBuilder();

        HashMap<Character, Integer> countMap = new HashMap<Character, Integer>();


        for (int i = 0; i < input.length(); i++) {
            if(countMap.isEmpty()){
                countMap.put(input.charAt(i),1);
            }else {
                if(countMap.containsKey(input.charAt(i))){
                    countMap.put(input.charAt(i), countMap.get(input.charAt(i))+1);
                }else{
                    countMap.put(input.charAt(i),1);
                }
            }
        }

        int maxCount = 0;
        char maxChar = 'a';
        for (Map.Entry<Character, Integer> entrySet : countMap.entrySet()) {
            System.out.println(entrySet.getKey() + " : " + entrySet.getValue());



            if(maxCount < entrySet.getValue()){
                maxCount = entrySet.getValue();
                maxChar = entrySet.getKey();
            }

        }

        System.out.println("가장 많이반복되는 문자는 :  " + maxChar);
        System.out.println("가장 많이반복되는 문자의 갯수 :  " + maxCount);


        return maxChar;
    }


}
