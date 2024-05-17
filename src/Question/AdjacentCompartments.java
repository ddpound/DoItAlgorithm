package Question;

import java.util.ArrayList;

public class AdjacentCompartments {

    public static void main(String[] args) {

    }

    public int solution(String[][] board, int h, int w) {
        int answer = 0;

        ArrayList<String> targetList = new ArrayList<>();

        if(h+1 < board.length) targetList.add(board[h+1][w]);
        if(h-1 >= 0) targetList.add(board[h-1][w]);
        if(w+1 < board.length) targetList.add(board[h][w+1]);
        if(w-1 >= 0) targetList.add(board[h][w-1]);

        String target1 = board[h][w];

        for (String t : targetList){
            if(target1.equals(t)){
                answer +=1;
            }
        }


        return answer;
    }
}
