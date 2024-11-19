package Day12;

import java.util.Scanner;

public class Exercises {
    public static void main(String[] args) {
        divideHundred();
    }

    private static void divideHundred() {
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter number");
        int x = sc.nextInt();
        try{
            System.out.println("100 divided by " + x + " is " + 100/x);
        } catch(ArithmeticException e) {
            System.out.println("cannot divide by zero");
        }
    }

}
