import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {

    public static final int NOT_EXISTING_USER_ID = 2;
    private AccountHolder accountHolder;
    private BankAccount bankAccount;
    public static final int INITIAL_BALANCE = 0;
    public static final int MONEY_100$ = 100;
    public static final int MONEY_70$ = 70;
    public static final int MONEY_50$ = 50;
    public static final int EXPECTED_100$ = 100;
    public static final int EXPECTED_30$ = 30;

    @BeforeEach
    void initAccount(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccount(accountHolder, INITIAL_BALANCE);
    }

    @Test
    void initialBalance() {
        assertEquals(INITIAL_BALANCE, bankAccount.getBalance());
    }

    @Test
    void deposit() {
        bankAccount.deposit(accountHolder.getId(), MONEY_100$);
        assertEquals(EXPECTED_100$, bankAccount.getBalance());
    }

    @Test
    void wrongDeposit() {
        bankAccount.deposit(accountHolder.getId(), MONEY_100$);
        bankAccount.deposit(NOT_EXISTING_USER_ID, MONEY_50$);
        assertEquals(EXPECTED_100$, bankAccount.getBalance());
    }

    @Test
    void withdraw() {
        bankAccount.deposit(accountHolder.getId(), MONEY_100$);
        bankAccount.withdraw(accountHolder.getId(), MONEY_70$);
        assertEquals(EXPECTED_30$, bankAccount.getBalance());
    }

    @Test
    void wrongWithdraw() {
        bankAccount.deposit(accountHolder.getId(), MONEY_100$);
        bankAccount.withdraw(NOT_EXISTING_USER_ID, MONEY_70$);
        assertEquals(EXPECTED_100$, bankAccount.getBalance());
    }
}
