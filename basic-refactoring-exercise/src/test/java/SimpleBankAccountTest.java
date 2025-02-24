import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {

    public static final int INITIAL_BALANCE = 0;
    public static final int NOT_EXISTING_USER_ID = 2;
    public static final int EXPECTED_AMOUNT = 100;
    public static final int DEPOSIT_AMOUNT = 100;
    public static final int DEPOSIT_AMOUNT_NOT_EXISTING_USER = 50;
    public static final int WITHDRAW_AMOUNT = 70;
    public static final int WITHDRAW_TOO_HIGH_AMOUNT = 100;
    public static final int EXPECTED_AMOUNT_AFTER_WITHDRAW = 29;
    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void initAccount(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccount(accountHolder, INITIAL_BALANCE);
    }

    @Test
    void initialBalance() {
        assertAll(
                () -> assertEquals(INITIAL_BALANCE, bankAccount.getBalance()),
                () -> assertEquals(1, accountHolder.getId())
        );
    }

    @Test
    void deposit() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        assertEquals(EXPECTED_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void wrongDeposit() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        bankAccount.deposit(NOT_EXISTING_USER_ID, DEPOSIT_AMOUNT_NOT_EXISTING_USER);
        assertEquals(EXPECTED_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void withdraw() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        bankAccount.withdraw(accountHolder.getId(), WITHDRAW_AMOUNT);
        assertEquals(EXPECTED_AMOUNT_AFTER_WITHDRAW, bankAccount.getBalance());
    }

    @Test
    void wrongUserWithdraw() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        bankAccount.withdraw(NOT_EXISTING_USER_ID, WITHDRAW_AMOUNT);
        assertEquals(EXPECTED_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void notEnoughMoneyWithdraw() {
        bankAccount.deposit(accountHolder.getId(), DEPOSIT_AMOUNT);
        bankAccount.withdraw(accountHolder.getId(), WITHDRAW_TOO_HIGH_AMOUNT);
        assertEquals(EXPECTED_AMOUNT, bankAccount.getBalance());
    }
}
