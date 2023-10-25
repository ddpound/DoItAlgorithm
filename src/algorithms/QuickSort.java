package algorithms;

import java.util.Random;

// 퀵 정렬 알고리즘
public class QuickSort {
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

    static void partition(int[] a, int n){

        int pl = 0;
        int pr = n-1;
        int x = a[n/2]; // x가 피벗, 반으로 나눔

        do {
            while(a[pl] < x) pl++;
            while(a[pr] > x) pr--;
            if(pl <= pr){
                swap(a,pl++,pr--);
            }
        }while (pl <= pr);

        System.out.println("피벗의 값은 "+ x +"입니다.");

        System.out.println("피벗 이하의 그룹");
        for (int i = 0; i <= pl; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        if(pl > pr +1){
            System.out.println("피벗과 일치하는 그룹");
            for (int i = pr+1; i <= pl  ; i++) {
                System.out.print(a[i]+ " ");
            }
            System.out.println();
        }


        System.out.println("피벗과 이상의 그룹");
        for (int i = pr+1; i < n  ; i++) {
            System.out.print(a[i]+ " ");
        }
        System.out.println();

    }


    public static int[] generateRandomArray(int size, int min, int max) {
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }

        return array;
    }

    public static void main(String[] args) {
        int size = 10; // 배열 크기
        int min = 1;   // 난수 범위 최솟값
        int max = 50; // 난수 범위 최댓값

        int[] array1 = generateRandomArray(size, min, max);
        int[] array2 = generateRandomArray(size, min, max);
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + " ");
        }
        System.out.println();
        //partition(array, size);
        quickSort(array1,0, size-1);

        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + " ");
        }

        System.out.println();
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array2[i] + " ");
        }

        bubbleSort(array2, size);
        System.out.println();

        for (int i = 0; i < array1.length; i++) {
            System.out.print(array2[i] + " ");
        }


    }

}
