package Question;


import java.util.HashMap;

// 코딩테스트
// https://school.programmers.co.kr/learn/courses/30/lessons/118666
public class PersonalityType {

    public static void main(String[] args) {
        String[] input1 = {"AN", "CF", "MJ", "RT", "NA"};
        int[] input2 = {5, 3, 2, 7, 5};

        System.out.println(solution(input1,input2));
    }


    public static String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();

        String[] personalityTypeList = {"R","T","C","F","J","M","A","N"};

        HashMap<String, Integer> totalList = new HashMap<>();
        totalList.put("R",0);
        totalList.put("T",0);
        totalList.put("C",0);
        totalList.put("F",0);
        totalList.put("J",0);
        totalList.put("M",0);
        totalList.put("A",0);
        totalList.put("N",0);

        int[] score = {3,2,1,0,1,2,3};


        for (int i = 0; i < survey.length; i++) {

            if(choices[i] < 4){
                totalList.put(String.valueOf(survey[i].charAt(0)), totalList.get(String.valueOf(survey[i].charAt(0))) + score[choices[i]-1]);

            }else if (choices[i] > 4){
                totalList.put(String.valueOf(survey[i].charAt(1)), totalList.get(String.valueOf(survey[i].charAt(1))) + score[choices[i]-1]);

            }

        }


        for (int i = 0; i < personalityTypeList.length;) {

            if(totalList.get(personalityTypeList[i]) == totalList.get(personalityTypeList[i+1])){
                if(personalityTypeList[i].charAt(0) > personalityTypeList[i+1].charAt(0)){
                    answer.append(personalityTypeList[i+1]);
                }else{
                    answer.append(personalityTypeList[i]);
                }
            } else if(totalList.get(personalityTypeList[i]) > totalList.get(personalityTypeList[i+1])){
                answer.append(personalityTypeList[i]);
            }else {
                answer.append(personalityTypeList[i+1]);
            }

            i+=2;

        }


        return answer.toString();
    }





}
