package Question;

import java.util.ArrayList;
import java.util.Collections;

/**
 * K 번째 수
 * 프로그래머스
 * https://school.programmers.co.kr/learn/courses/30/lessons/42748
 *
 *
 * // 버블정렬로 해도 충분함 array 길이는 100을 넘지 않음
 * */
public class KthNumber {

    public static void main(String[] args) {

    }

    public static int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> tempList = new ArrayList<>();
        int[] answer = new int[commands.length];
        int loopNumber = 0;


        for (int[] commoand : commands){
            tempList = new ArrayList<>();
            // -1 을 넣어줘야 순서가 맞음, 최소 숫자 0
            int i = commoand[0]-1;
            int j = commoand[1]-1;
            int k = commoand[2]-1;

            for (int l = i; l <= j ; l++) {
                tempList.add(array[l]);
            }

            Collections.sort(tempList);
            answer[loopNumber] = tempList.get(k);
            loopNumber++;
        }

        return answer;
    }


    static void bubbleSort(int[] a, int n){
        int k =0;
        while (k < n-1){
            int last = n-1;
            for (int i = n-1; i > k; i--) {
                if(a[i -1] > a[i]){
                    swap(a,i-1,i);
                    last = i; // 마지막으로 바꾼위치, 즉 모두 바꿨을 때
                }
            }
            k = last;
        }
    }

    static void swap(int[]a, int idx1, int idx2){
        int i = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = i;
    }
}
