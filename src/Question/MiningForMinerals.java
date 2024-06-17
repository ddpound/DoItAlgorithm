package Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 프로그래머스 광물 캐기
 * https://school.programmers.co.kr/learn/courses/30/lessons/172927
 *
 *
 * 아이디어
 * 1. pick의 length 는 무조건 3
 * 2. 문제 자체가 함정이 있는게 예시는 diamond만 얍삽하게 앞에다 위치시켜서 혼동을 줌
 * 3. 오히려 반례 찾기가 더쉬움 stone이 앞열에 있으면 돌 곡괭이를 쓰는게 전략상 좋음
 * 4. 정리하면 곡괭이는 한번 쓰면 5번은 무조건 사용해야하니깐 slice 알고리즘을 사용하면 됨 two point 알고리즘이였나..?
 *
 * 풀이
 * 1. 길이가 5인 슬라이스를 돌려서 가장 많은 돌의 개수를 파악, 중요한점은 5개로 자른 리스트들은 섞어서 사용해도됨
 * 2. 그리드 알고리즘이 통함
 * 3. 그리고 곡괭이 갯수 * 5 가 전체 채광 길이보다 짧으면 마지막 인덱스를 거기로 해야함
 * */
public class MiningForMinerals {

    public static void main(String[] args) {
        int[] param1 = new int[]{1,3,2};
        String[] param2 = new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        System.out.println(solution(param1,param2));

        int[] param3 = new int[]{0,1,1};
        String[] param4 = new String[]{"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};
        System.out.println(solution(param3,param4));

        int[] param5 = new int[]{2,3,5};
        String[] param6 = new String[]{"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond","diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        System.out.println(solution(param5,param6));

        int[] param7 = new int[]{0,0,1};
        String[] param8 = new String[]{"iron", "iron", "iron", "iron", "diamond","diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone","diamond", "diamond", "diamond", "diamond", "diamond", "iron"};
        System.out.println(solution(param7,param8));

        int[] param9 = new int[]{1,0,1};
        String[] param10 = new String[]{"iron", "iron", "iron", "iron", "diamond"};
        System.out.println(solution(param9,param10));
    }

    public static int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int listNumber = minerals.length % 5 > 0 ? minerals.length / 5 + 1 : minerals.length / 5;
        int mineNumber = minerals.length;
        int pickaxNumber = 0;

        // 곡괭이 갯수
        for (int i : picks){
            pickaxNumber += i;
        }

        pickaxNumber *= 5;

        if(pickaxNumber < mineNumber) {
            mineNumber = pickaxNumber;
            listNumber = pickaxNumber / 5;
        }

        // {startIndex,endIndex,sum}
        int[][] list = new int[listNumber][3];

        int step = 0; // 넘어갈 step
        int forStep = 0;
        int sum = 0;
        int startIndex = 0;

        for (int i = 0; i < mineNumber; i++) {
            char c = minerals[i].charAt(0);

            if (c == 'd') sum += 25;
            if (c == 'i') sum += 5;
            if (c == 's') sum += 1;


            if(forStep == 4 || i == mineNumber - 1){
                list[step][0] = startIndex;
                list[step][1] = i;
                list[step][2] = sum;

                step++;
                forStep = 0;
                sum = 0;
                startIndex = i+1;
            }else{
                forStep++;
            }


        }

        System.out.println(Arrays.deepToString(list));
        quickSort(list , 0, list.length-1);

        int result = 0;
        // grid 알고리즘 진행
        for (int i = list.length-1; i >= 0; i--){
            int start = list[i][0];
            int end = list[i][1];
            int pickIndex = 0;

            // 반복해서 값을 가져옴
            for (int j = start; j <= end; j++) {
                char c = minerals[j].charAt(0);

                if(picks[0] > 0){
                    result += 1;
                    pickIndex = 0;
                }else if(picks[1] > 0){
                    if (c == 'd') result += 5;
                    else result += 1;
                    pickIndex = 1;
                } else if (picks[2] > 0) {
                    if (c == 'd') result += 25;
                    if (c == 'i') result += 5;
                    if (c == 's') result += 1;
                    pickIndex = 2;
                }

            }

           picks[pickIndex] -= 1;
        }

        System.out.println(Arrays.deepToString(list));
        return result;
    }


    // 값 변경, static 이여서 따로 반환하지 않아도 적용된다.
    static void swap(int[]a, int idx1, int idx2){
        int i = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = i;
    }

    static void swap(int[][]a, int idx1, int idx2){
        int[] i = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = i;
    }

    static void quickSort(int[][] a, int left, int right){
        int pl = left; // 왼쪽 커서
        int pr = right; // 오른쪽 커서
        int[] x = a[(pl + pr) /2]; // 피벗

        do {
            while(a[pl][2] < x[2]) pl++;
            while(a[pr][2] > x[2]) pr--;
            if(pl <= pr){
                swap(a, pl++, pr--);
            }
        }while (pl <= pr);

        if(left < pr) quickSort(a, left, pr);
        if(pl < right) quickSort(a, pl, right);
    }


}
