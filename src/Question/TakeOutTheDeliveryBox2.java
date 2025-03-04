package Question;

import java.util.Arrays;

public class TakeOutTheDeliveryBox2 {

    public static void main(String[] args) {
        System.out.println(solution(100,1,33));
    }

    public static int solution(int n, int w, int num) {
        int answer = 0; // 자기 자신 상자를 포함하니 1
        int boxNumber = n;
        int box = 1;
        int h = n/w;
        if(n%w > 0) h++;

        // 0은 빈공간을 의미
        int wPoint = 0;
        int hPoint = 0;

        // 적재할 공간
        int[][] boxSpace = new int[h][w];
        boolean reverseLoad = false;

        for(int i = 0; i < h; i++){
            int startPoint = reverseLoad ? w-1 : 0;

            for (int j = 0; j < w; j++) {

                if(boxNumber > 0){

                    boxSpace[(h-1)-i][startPoint] = box;

                    if(box == num){
                        wPoint = startPoint;
                        hPoint = (h-1)-i;
                    }

                    if(reverseLoad) startPoint--;
                    else startPoint++;

                    box++;
                    boxNumber--;
                }
            }

            reverseLoad = !reverseLoad;
        }

        //System.out.println(Arrays.deepToString(boxSpace));

        // 위치를 찾았으니 적재위치에서 위로 하나씩 체크
        for (int i = hPoint; i >= 0 ; i--){
            if(boxSpace[i][wPoint] == 0){
                break;
            }else{
                answer++;
            }
        }

        return answer;
    }
}
