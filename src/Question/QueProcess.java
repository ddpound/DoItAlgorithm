package Question;


import java.util.ArrayList;

public class QueProcess {

    static class processObject{
        private int number;
        private int id;

        public processObject(int number, int id) {
            this.number = number;
            this.id = id;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public static void main(String[] args) {
        int[] prioriteies = {1, 1, 9, 1, 1, 1};

        System.out.println(solution(prioriteies, 0));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        ArrayList<processObject> processQue = new ArrayList<>();
        ArrayList<processObject> processList = new ArrayList<>();

        for (int i = 0; i < priorities.length; i++) {
            processQue.add(new processObject(priorities[i],i));
        }
        processCalc(processQue,processList);

        for (int i = 0; i < processList.size(); i++) {
            if (processList.get((processList.size()-1) - i).getId() == location) {
                answer = i+1;
                break;
            }
        }
        return answer;
    }

    public static void processCalc(ArrayList<processObject> queList,ArrayList<processObject> processList){
        boolean tryRun = false;
        processObject run = queList.get(0);

        for (processObject i : queList
             ) {
            if (run.getNumber() < i.getNumber()) {
                tryRun = true;
                break;
            }
        }

        if(tryRun){
            queList.add(run);
            queList.remove(0);
        }else{
            processList.add(run);
            queList.remove(0);
        }

        if(queList.size() > 0){
            processCalc(queList,processList);
        }
    }

}
