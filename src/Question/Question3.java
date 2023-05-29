package Question;

public class Question3 {

    public static void main(String[] args) {
        String input = "44335550555666";
        String input1 = "9666775553";
        System.out.println(solution(input));
    }

    public static String solution(String s) {
        StringBuilder answer = new StringBuilder();


        int[] input = new int[s.length()];

        for (int j = 0; j <s.length() ; j++) {
            input[j] = Integer.parseInt(String.valueOf(s.charAt(j)));
        }
        for (int j : input) {
            System.out.print(j + " ");
        }

        // 키 값 확인
        for (int i = 0; i < input.length; i++) {
            int cNum = counting(input , i);
            boolean next = true;

            if(input[i] == 1 && next){
                if(cNum == 1){
                    answer.append(".");
                    next = false;
                } else if (cNum ==2) {
                    answer.append("Q");
                    i =  plus(input, i, 2);
                    next =false;
                }else if (cNum ==3){
                    answer.append("Z");
                    i =  plus(input, i, 3);
                    next =false;
                }
            }
            if(input[i] == 2 && next){
                if(cNum ==1){
                    answer.append("A");
                    next =false;
                } else if (cNum ==2) {
                    answer.append("B");
                    i =  plus(input, i, 2);
                    next =false;
                }else if (cNum ==3){
                    answer.append("C");
                    i =  plus(input, i, 3);
                    next =false;
                }
            }
            if(input[i] == 3 && next){
                if(cNum ==1){
                    answer.append("D");
                    next =false;
                } else if (cNum ==2) {
                    answer.append("E");
                    i =  plus(input, i, 2);
                    next =false;
                }else if (cNum ==3){
                    answer.append("F");
                    i =  plus(input, i, 3);
                    next =false;
                }
            }
            if(input[i] == 4 && next){
                if(cNum ==1){
                    answer.append("G");
                    next =false;
                } else if (cNum ==2) {
                    answer.append("H");
                    i =  plus(input, i, 2);
                    next =false;
                }else if (cNum ==3){
                    answer.append("I");
                    i =  plus(input, i, 3);
                    next =false;
                }
            }
            if(input[i] == 5 && next){
                if(cNum ==1){
                    answer.append("J");
                    next =false;
                } else if (cNum ==2) {
                    answer.append("K");
                    i =  plus(input, i, 2);
                    next =false;
                }else if (cNum ==3){
                    answer.append("L");
                    i =  plus(input, i, 3);
                    next =false;
                }
            }
            if(input[i] == 6 && next){
                if(cNum ==1){
                    answer.append("M");
                    next =false;
                } else if (cNum ==2) {
                    answer.append("N");
                    i =  plus(input, i, 2);
                    next =false;
                }else if (cNum ==3){
                    answer.append("O");
                    i =  plus(input, i, 3);
                    next =false;
                }
            }
            if(input[i] == 7 && next){
                if(cNum ==1){
                    answer.append("P");
                    next =false;
                } else if (cNum ==2) {
                    answer.append("R");
                    i =  plus(input, i, 2);
                    next =false;
                }else if (cNum ==3){
                    answer.append("S");
                    i =  plus(input, i, 3);
                    next =false;
                }
            }
            if(input[i] == 8 && next){
                if(cNum ==1){
                    answer.append("T");
                    next =false;
                } else if (cNum ==2) {
                    answer.append("U");
                    i =  plus(input, i, 2);
                    next =false;
                }else if (cNum ==3){
                    answer.append("V");
                    i =  plus(input, i, 3);
                    next =false;
                }
            }
            if(input[i] == 9 && next){
                if(cNum ==1){
                    answer.append("W");
                    next =false;
                } else if (cNum ==2) {
                    answer.append("X");
                    i =  plus(input, i, 2);
                    next =false;
                }else if (cNum ==3){
                    answer.append("Y");
                    i =  plus(input, i, 3);
                    next =false;
                }
            }

        }



        return answer.toString();
    }

    public static int counting(int[] input, int nowIndex){
        int sum = 1;


        if(nowIndex+1 <= input.length){
            if(input[nowIndex] == input[nowIndex+1]){
                sum = 2;
            }
        }

        if(nowIndex+2 <= input.length){
            if( input[nowIndex] == input[nowIndex+1] && input[nowIndex] == input[nowIndex+2]){
                sum = 3;
            }
        }

        return sum;
    }

    public static int plus(int[] input, int nowIndex, int plus){

        if(input.length > nowIndex+plus){
            return nowIndex+plus-1;
        }

        return nowIndex+2;
    }

}
