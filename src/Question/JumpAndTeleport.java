package Question;

public class JumpAndTeleport {

    public static void main(String[] args) {
        System.out.println(solution(6));
    }

    public static int solution(int n) {
        int ans = 1; // 현재까지 온 거리
        int step =1;

        while (true) {
            if(n % 2 == 0){
                n /= 2;
            }else{
                n--;
                ans++;
            }

            if(n ==0 ){
                return ans-1;
            }
        }
    }

}
