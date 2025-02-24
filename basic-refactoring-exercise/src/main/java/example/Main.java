package example;

import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

public class Main {

    public static final int INITIAL_BALANCE = 0;
    public static final int MONEY_100$ = 100;
    public static final int MONEY_80$ = 80;
    public static final int MONEY_30$ = 30;

    public static void main(String[] args) {
        final AccountHolder accountHolder = new AccountHolder("Mario", "Rossi", 1);
        final BankAccount bankAccount = new SimpleBankAccount(accountHolder, INITIAL_BALANCE);

        bankAccount.deposit(accountHolder.getId(), MONEY_100$);
        System.out.println("Current balance is " + bankAccount.getBalance());

        bankAccount.withdraw(accountHolder.getId(), MONEY_30$);
        System.out.println("Current balance is " + bankAccount.getBalance());

        bankAccount.withdraw(accountHolder.getId(), MONEY_80$);
        System.out.println("Current balance is " + bankAccount.getBalance());
    }
}
