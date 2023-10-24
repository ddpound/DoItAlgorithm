package Question;


import java.util.ArrayList;

// https://school.programmers.co.kr/learn/courses/30/lessons/17681
// 프로그래머스 문제 비밀지도
public class SecretMap {

    public static void main(String[] args) {
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        System.out.println(solution(5,arr1,arr2));
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = {};
        ArrayList<String> arrayList1 = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();

        String resultString = "";
        ArrayList<String> resultList = new ArrayList<>();

        for (int i = 0; i < arr1.length; i++) {
            String binaryString1 = Integer.toBinaryString(arr1[i]);
            String binaryString2 = Integer.toBinaryString(arr2[i]);

            String zero1 = "";
            String zero2 = "";

            if(binaryString1.length() < n){
                for(int j = 0; j < n-binaryString1.length() ; j++ ){
                    zero1+="0";
                }
            }
            if(binaryString2.length() < n){
                for(int j = 0; j < n-binaryString2.length() ; j++ ){
                    zero2+="0";
                }
            }

            zero1 += binaryString1;
            zero2 += binaryString2;

            arrayList1.add(zero1);
            arrayList2.add(zero2);

            resultString = ""; // 한번 초기화
            for (int j = 0; j < zero1.length(); j++) {
                if(zero1.charAt(j) == '1' || zero2.charAt(j) == '1') {
                    resultString += "#";
                }else{
                    resultString += " ";
                }
            }

            resultList.add(resultString);
        }

        for (String i : arrayList1
             ) {
            System.out.println(i);
        }
        System.out.println();
        for (String i : arrayList2
        ) {
            System.out.println(i);
        }
        System.out.println();
        for (String i : resultList
        ) {
            System.out.println(i);
        }

        answer = new String[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            answer[i] = resultList.get(i);
        }

        return answer;
    }

}
