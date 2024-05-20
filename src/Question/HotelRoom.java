package Question;


import java.lang.reflect.Array;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// 프로그래머스 호텔대실
public class HotelRoom {

    public static void main(String[] args) {
        String[][] time = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};

        System.out.println(solution(time));

        String[][] time2 = {{"03:00", "12:50"}, {"01:40", "13:20"},{"00:50", "09:00"}, {"01:20", "23:55"}, {"04:10", "05:20"}, {"00:20", "01:20"}};

        System.out.println(solution(time2));
    }

    // 동일한 시간대면 무조건 방이 그만큼 있어야함
    // 각방에는 start 와 end 그리고 end와 새로운 start시간과 비교해야함
    // 각 방은 스택으로 쌓임

    public static int solution(String[][] book_time) {
        int answer = 0;
        int[][] dataList = new int[book_time.length][2];

        // 정렬 순서
        // 가장 빨리 시작하는 시간대
        // 스플릿을 통해 앞자리 수치화

        for (int i = 0; i < book_time.length; i++) {

            int startTime = 0;
            int endTime = 0;

            // DateTimeFormatter를 사용해 문자열을 LocalTime으로 파싱
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime time = LocalTime.parse(book_time[i][1], formatter);

            LocalTime addTime;

            addTime = time.plusMinutes(10);

            // 원래 자정이 아닌데 10분을 더하니깐 자정이 되었으면 초기화
            if (addTime.getHour() == 0 && time.getHour() != 0) {
                time = LocalTime.of(23, 59);
            }else{
                time = time.plusMinutes(10);
            }

            // 다시 문자열로 변환
            String newTimeString = time.format(formatter);

            String[] newStartTime = book_time[i][0].split(":");
            String[] newTime = newTimeString.split(":");


            startTime = Integer.parseInt((newStartTime[0] + newStartTime[1]));
            endTime = Integer.parseInt((newTime[0] + newTime[1]));


            dataList[i][0] = startTime;
            dataList[i][1] = endTime;
        }

        quickSort(dataList, 0 , dataList.length-1);

        System.out.println(Arrays.deepToString(dataList));

        ArrayList<Integer> timeList = new ArrayList<>();

        for (int[] data : dataList){
            if(timeList.isEmpty()){
                timeList.add(data[1]);
            }else{
                boolean find = false;
                for (int i = 0; i < timeList.size(); i++) {
                    if(timeList.get(i) <= data[0]){
                        timeList.set(i , data[1]);
                        find = true;
                        break;
                    }
                }
                if(!find){
                    timeList.add(data[1]);
                }
            }
        }

        System.out.println(timeList);
        answer = timeList.size();
        return answer;
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
            while(a[pl][0] < x[0]) pl++;
            while(a[pr][0] > x[0]) pr--;
            if(pl <= pr){
                swap(a,pl++,pr--);
            }
        }while (pl <= pr);

        if(left < pr) quickSort(a, left, pr);
        if(pl < right) quickSort(a, pl, right);
    }

}
