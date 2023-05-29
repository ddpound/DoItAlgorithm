package week1;

public class StringIndexing {


    public static void main(String[] args) {
        String[] input1 = {"sun", "bed", "car"};
        String[] input2 = {"abce", "abcd", "cdx"};
        int n1 = 1;
        int n2 = 2;

    }

    public static String[] solution(String[] strings, int n) {

        for (int i = 0; i < strings.length; i++) {

            int asc = strings[i].charAt(n);

            for(int j=i+1; j< strings.length; j++ ){
                int asc2 = strings[j].charAt(n);
                if(asc < asc2){

                }

            }



        }

        String[] answer = {};
        return answer;
    }
}
