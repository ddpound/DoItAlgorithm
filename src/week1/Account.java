package week1;

public class Account {
    int balance;
    int id;
    public Account() {

        System.out.println("쨘 어카운트 생성자를 만들었습니다!");
        balance = 0;
    }
    public Account(int initAmount) {
        balance = initAmount;
    }
    public void deposit(int amount) {
        balance += amount;
    }
    public void withdraw(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public void getBalance(int a) {

        System.out.println(" 쨘 이건 오버로드한거에요");
    }


    public static void main(String[] args) {
        Account my = new Account();
        Account yours = new Account(1000);

        System.out.println("My Acount = "+my.getBalance());
        System.out.println("Yours ="+yours.getBalance());

    }

}
