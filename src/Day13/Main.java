package Day13;

import java.util.Scanner;

public class Main {

    static String s;
    public static void main(String[] args) {

//        intToString(123);
//        stringBackToInt(s);
//        canConvertToInteger();
        reverseAndConvertInt();
        reverseAndConvertInt2();


    }

    private static void reverseAndConvertInt() {
        String text = "123456";
        StringBuilder newText= new StringBuilder();
        for (int i = text.length()-1; i >= 0; i--) {
            newText.append(text.charAt(i));
        }
        String toInt = newText.toString();
        int x = Integer.parseInt(toInt);
        System.out.println(x);

    }

    private static void canConvertToInteger() {
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();
        try {
            Integer.parseInt(s);
            System.out.println(s);
        } catch (NumberFormatException e) {
            System.out.println( s + " can not be converted to string");
        }
    }

    private static String intToString(int num) {
        s = Integer.toString(num);
        System.out.println(s + "string");
        System.out.println(s.getClass());
        return s;

    }

    private static void stringBackToInt(String s) {
        int x = Integer.parseInt(s);
        System.out.println(x);

    }

    private static void reverseAndConvertInt2() {
        String text = "123456";
        String newText = "";
        for (int i = text.length()-1; i >= 0; i--) {
            newText += text.charAt(i);
        }
        int x = Integer.parseInt(newText);
        System.out.println(x);

    }



}
