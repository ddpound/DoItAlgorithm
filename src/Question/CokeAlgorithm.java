package Question;

public class CokeAlgorithm {

    private static int result;
    private static int remainSum;

    public static void main(String[] args) {

        int a = 2;
        int b = 1;
        int n = 20;

        System.out.println(solution(a,b,n));

        System.out.println("나머지 : "+remainSum);
    }
    public static int solution(int a, int b, int n) {
        int answer = 0;
        int remain = 0;


        result(n,a,b, remain, answer);

        answer = result;

        return answer;
    }

    public static void result(int n , int a, int b, int remain, int answer){

        if (n+remainSum <= a) {
            answer+=1;
            System.out.println("마지막 : "+ answer);

            result = answer;
        } else {

            n = n/a;
            remain = n&a;

            answer += n;
            remainSum += n%a;

            System.out.println(answer);
            result(n/a, a, b, remain ,answer);
        }

    }

//    a b n
//
//   3 2 20
//
//        20/3 ---6...2
//
//    n = 6
//
//    n/a -> 6/3 --- 2...0
//
//            6+2,
//            if 2+0 < a ---> return 6+2
//            else ----> return 나머지의 합/a+(6+2)
//    elif 나머지의합/a > a
//
//  if 나머지의 합 ==10
//            10/a ==5
//            5/a ==2....1



}
