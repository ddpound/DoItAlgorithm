package week1;

public class MileageAccount extends MinusAccount{
    double mileRatio;

    public static void main(String[] args) {
        MileageAccount mileageAccount1 = new MileageAccount(); // 비율이 기본 생성자 0.1 일때
        MileageAccount mileageAccount2 = new MileageAccount(0.5); // 직접 값을 설정한 비율이 0.5일때

        System.out.println(mileageAccount1.getBalance());
        System.out.println(mileageAccount2.getBalance());

    }



    public MileageAccount(){
        mileRatio = 0.1;
        balance+= (balance*mileRatio);
    }

    public MileageAccount(double ratio){
        mileRatio = ratio;

        balance+= (balance*mileRatio);

    }



}
