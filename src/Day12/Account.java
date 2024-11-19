package Day12;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String name;
    private double balance;
    private int PIN;

    public Account(String name, double balance, int PIN) {
        this.name = name;
        this.balance = balance;
        this.PIN = PIN;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance() {
        this.balance = balance;
    }

    public int getPIN() {
        return PIN;
    }

    public void setPIN() {
        this.PIN = PIN;
    }

    public static List<Account> accountList = new ArrayList<>(List.of(
            new Account("a1",1000.00, 1111),
            new Account("a2",5500, 2222),
            new Account("a3",7500, 3333)
    ));


}
