package Question;

import java.util.Arrays;

public class Question4 {

    public static void main(String[] args) {
        int[] test1 = {3,1,4,1,5,9,2,6,5,3};
        int n = 10;
        System.out.println(solution(n, test1));

    }

    static void swap(int[]a, int idx1, int idx2){
        int i = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = i;
    }

    public static int solution(int n, int[] v) {
        int answer;
        int[] clone1 = v.clone();

        // 구매날짜
        int sellDay = 0;

        // 가장 큰 값
        quickSort(clone1, 0, n-2);

        for (int i = 0; i < v.length-1; i++) {
            if(v[i] == clone1[0]){
                sellDay = i;
            }
        }
        int[] clone2 = Arrays.copyOfRange(v,sellDay+1, v.length);

        quickSort(clone2, 0, clone2.length-1);

        System.out.println(sellDay);
        System.out.println(clone1[0]);
        System.out.println(clone2[0]);

        System.out.println(Arrays.toString(Arrays.stream(clone2).toArray()));

        answer = clone1[0] - clone2[clone2.length-1];
        return answer;
    }

    static void quickSort(int[] a, int left, int right){
        int pl = left; // 왼쪽 커서
        int pr = right; // 오른쪽 커서
        int x = a[(pl + pr) /2]; // 피벗

        do {
            while(a[pl] > x) pl++;
            while(a[pr] < x) pr--;
            if(pl <= pr){
                swap(a,pl++,pr--);
            }
        }while (pl <= pr);

        if(left < pr) quickSort(a, left, pr);
        if(pl < right) quickSort(a, pl, right);
    }

}
