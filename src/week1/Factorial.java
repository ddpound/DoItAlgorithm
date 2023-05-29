package week1;

import java.util.Scanner;

public class Factorial {

    public double getFactorial(double inNum){
        Scanner sc = new Scanner(System.in);
        double factorialResult=0;

        for(int i=1; i <= inNum; i++){
            if(i==1){
                factorialResult = inNum;
            }
            if(inNum-i==0){
                break;
            }
            factorialResult *= (inNum-i);
        }

        return factorialResult;
    }



}
