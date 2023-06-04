package Question;

public class CokeAlgorithm {

    private static int result;
    private static int remainSum;

    public static void main(String[] args) {

        int a = 2;
        int b = 1;
        int n = 20;

        System.out.println(solution(a,b,n));
        //result(n,a,b);
    }
    public static int solution(int a, int b, int n) {
        int answer = 0;

        return result(n,a,b, answer);
    }

    public static int result(int n , int a, int b, int answer){


        if(n >= a){
            answer += (n / a) * b;
            int remain = n % a;
            n = (n / a) * b + remain;


            result(n, a, b, answer);
        }

        return answer;
    }

    public static void result(int n , int a, int b){

        int answer =0 ;
        while (n >= a) {

            answer += (n / a) * b;
            int remain = n % a;

            n = (n / a) * b + remain;
        }

        System.out.println("값"+answer);

    }



}
