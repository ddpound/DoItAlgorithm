package week1;

public class MinusAccount extends Account{
    private int limit;

    public static void main(String[] args) {
        MinusAccount minusAccount = new MinusAccount(3000, 3000,1);

        System.out.println(minusAccount.getMinusBalance(6000));

    }

    public MinusAccount(){
        limit = 1000;
        balance = 1000;
    }

    public MinusAccount(int limitMoney, int Money,int intputId){
        limit =limitMoney;
        balance = Money;
        id= intputId;
    }

    // 인출하기 함수, 메소드
    public int getMinusBalance(int money){
        balance -= money;

        if(-(limit) > balance){
            System.out.println("마이너스 잔고 초과입니다, ");
            balance += money; // 다시 원상복귀
            return balance;
        }


        return balance;
    }

}
