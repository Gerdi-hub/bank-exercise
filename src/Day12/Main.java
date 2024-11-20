package Day12;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Account account;
    static double balance;
    static int pin;
    static String name;


    public static void main(String[] args) {
        getUser();
        chooseNext();
    }

    public static void getUser() {
        Scanner scan = new Scanner(System.in);

        boolean correctUser = false;

        while (!correctUser) {
            System.out.println("Please enter name: ");
            name = scan.nextLine();
            for (Account oneAccount : Account.accountList) {
                if (name.equals(oneAccount.getName())) {
                    correctUser = true;
                    balance = oneAccount.getBalance();
                    pin = oneAccount.getPIN();
                    account = oneAccount;
                    validatePin();
                    break;
                }
            }
            if (!correctUser) {
                System.out.println("Name not found. ");
            }
        }


    }

    public static void validatePin() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a valid pin");
        int enteredPin = 0;
        boolean validInput = false;
        while (!validInput) {
            if (scan.hasNextInt()) {
                enteredPin = scan.nextInt();
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a numeric PIN.");
                scan.next();
            }

        }

        int count = 1;

        while (enteredPin != pin) {
            count++;
            System.out.println("Invalid pin.");
            if (count > 3) {
                System.out.println("Too many wrong pin-s");
                System.exit(0);
            }
            System.out.println("Please enter a valid pin. Remaining trues: " + count);
            enteredPin = scan.nextInt();


        }
        System.out.println("Correct pin");
        printBalance();

    }

    public static void printBalance() {
        System.out.println("Balance is: " + balance);
    }

    public static void chooseNext() {
        boolean exit = false;

        while (!exit) {
            System.out.println("What would you like to do next? Enter number");
            System.out.println("1- Balance; 2- Withdraw money; 3- deposit money; 4- change pin; 5- exit;");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    printBalance();
                    break;
                case 2:
                    withdrawMoney();
                    break;
                case 3:
                    depositMoney();
                    break;
                case 4:
                    changePin();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }

        }


    }

    private static void changePin() {
        System.out.println("Please enter new pin: ");
        Scanner scan = new Scanner(System.in);
        int pin1 = scan.nextInt();
        System.out.println("Please enter new pin again");
        int pin2 = scan.nextInt();
        if (pin1 == pin2) {
            pin = pin1;
            System.out.println("You have changed the pin");
        } else {
            System.out.println("Unable to change pin, pin 1 and pin 2 does not mach");
            chooseNext();
        }
    }

    private static void depositMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount to deposit: ");
        double amount = 0;
        try {
            amount = sc.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }

        balance -= amount;
        printBalance();
    }

    private static void withdrawMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        if (amount>0){
            if (balance >= amount) {
                balance -= amount;
            } else {
                System.out.println("Unable to withdraw money, not enough balance");
            }
            printBalance();
        } else {
            System.out.println("Unable to withdraw negative amount");
        }

    }


}