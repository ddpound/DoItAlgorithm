package Question;


// 프로그래머스 바탕화면 정리
/**
 * ".........."
 * ".....#...."     1,5
 * "......##.."   2,7
 * "...##....."  3,3
 * "....#....."   4,4
 *
 * 1,3         4,7 +1 5,8
 *
 * Top 은 (y,x) y가 가장 낮은 축
 * left는 (y,x) 중 x가 가장 낮은 축
 *
 * Right 는(y,x ) x가 가장큼
 * Bottom 은 (y,x)중 y가 가장큼
 * */
public class WallPaperClean {


    public static void main(String[] args) {

    }

    // (1,3) 1 이 y축 3dl x축이다
    // top, left 를 구해서 left 는 탑으로 계속올려서 만나는 점 top 은 왼쪽으로 계속 보내서 만나게 하자
    // right는 아래로 계속 내리고, bottom은 오른쪽으로 계속 보내자
    // 그럼 먼저 top, left,right, bottom을 구해야함
    // 다 구했으면 각각의순서대로 진행
    public static int[] solution(String[] wallpaper) {
        // (y,x)

        int top = 10000; // y, i가 낮은수
        int left = 10000; //  j가 가장 낮은 수
        int bottom = 0; // i가 가장큼
        int right = 0; // j가 가장큼

        // i 가 y축이 됨
        for (int i = 0; i < wallpaper.length; i++) {

            for (int j = 0; j < wallpaper[i].length(); j++) {
                char a = wallpaper[i].charAt(j);

                if(a == '#'){
                    if(top > i) top = i;
                    if(left > j) left = j;
                    if(bottom < i) bottom = i;
                    if(right < j) right = j;
                }

            }
        }
        int[] answer = {top,left,bottom+1,right+1};

        return answer;
    }
}
