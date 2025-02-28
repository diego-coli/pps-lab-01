package example;
import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

public class Main {

    public static final int INITIAL_BALANCE = 0;
    public static final int DEPOSIT = 100;
    public static final int WITHDRAW = 80;
    public static final int WITHDRAW_TOO_HIGH = 30;

    public static void main(String[] args) {
        final AccountHolder accountHolder = new AccountHolder("Mario", "Rossi", 1);
        final BankAccount bankAccount = new SimpleBankAccount(accountHolder, INITIAL_BALANCE);

        bankAccount.deposit(accountHolder.getId(), DEPOSIT);
        System.out.println("Current balance is " + bankAccount.getBalance());

        bankAccount.withdraw(accountHolder.getId(), WITHDRAW);
        System.out.println("Current balance is " + bankAccount.getBalance());

        bankAccount.withdraw(accountHolder.getId(), WITHDRAW_TOO_HIGH);
        System.out.println("Current balance is " + bankAccount.getBalance());
    }
}
