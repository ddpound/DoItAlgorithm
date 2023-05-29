package Question;

public class Question1 {

    public static void main(String[] args) {
        String[] maps1 = {"0000000111", "1110010110","1110111000","0000000111"};
        String[] maps2 = {"111", "000","000","110"};

        solution(maps1);


    }

    public static int solution(String[] maps) {
        int answer = 0;

        int[][] array = new int[4][10];

        for (int i = 0; i < maps.length; i++) {

            for (int j = 0; j < maps[i].length() ; j++) {
                array[i][j] = Integer.parseInt(String.valueOf(maps[i].charAt(j)));
            }
        }

        // 가공후..
        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array[i].length ; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        // 섬 크기 구하기
        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array[i].length ; j++) {

                if(array[i][j] != 0){

                }
            }

        }


        return answer;
    }

    public static int size(int[][] array,int x, int y, int size){
        int sizeNum =0;

        // 맨 윗줄
        if (x == 0 && y < array[x].length){
            if(array[x][y+1] == 1){
                sizeNum ++;
                size(array,x,y+1,sizeNum);
            }
        }

        if(array[x][y] != 0){
            sizeNum ++;

        }

        return sizeNum;
    }
}
