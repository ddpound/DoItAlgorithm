package Question;

import java.util.ArrayList;

// 더맵게
// https://school.programmers.co.kr/learn/courses/30/lessons/42626
public class MoreSpicy {

    public static void main(String[] args) {

    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        double sumScovile = 0;

        quickSort(scoville,0,scoville.length-1);
        ArrayList<Double> list = new ArrayList<Double>();

        for (int i = 0; i < scoville.length; i++) {
            list.add((double) i);
        }

        ArrayList<Double> list2 = new ArrayList<Double>();

        for (int i = 0; i < list.size(); i++) {
            quickSort(scoville,0,scoville.length-1);
            sumScovile = scoville[i] + (scoville[i+1] * 2);

            if(sumScovile >= K){
                answer++;
                break;
            }

            answer++;

            if(i == scoville.length-1){
                answer = -1;
            }
        }


        return answer;
    }

    // 값 변경, static 이여서 따로 반환하지 않아도 적용된다.
    static void swap(int[]a, int idx1, int idx2){
        int i = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = i;
    }

    static void quickSort(int[] a, int left, int right){
        int pl = left; // 왼쪽 커서
        int pr = right; // 오른쪽 커서
        int x = a[(pl + pr) /2]; // 피벗

        do {
            while(a[pl] < x) pl++;
            while(a[pr] > x) pr--;
            if(pl <= pr){
                swap(a,pl++,pr--);
            }
        }while (pl <= pr);

        if(left < pr) quickSort(a, left, pr);
        if(pl < right) quickSort(a, pl, right);
    }

}
