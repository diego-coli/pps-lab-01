package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmartDoorLockTest {

    public static final int PIN = 1234;
    public static final int UNCORRECT_PIN = 9999;
    private SmartDoorLock smartDoorLock;

    @BeforeEach
    void initSmartDoorLock(){
        smartDoorLock = new SimpleSmartDoorLock();
    }

    @Test
    void isInitiallyUnlocked(){
        assertFalse(smartDoorLock.isLocked());
    }

    @Test
    void isInitiallyBlocked(){
        assertFalse(smartDoorLock.isBlocked());
    }

    @Test
    void setPin(){
        if(!smartDoorLock.isLocked()){
            smartDoorLock.setPin(PIN);
        }
        assertTrue(smartDoorLock.isLocked());
    }

    @Test
    void correctPin(){
        if(smartDoorLock.isLocked()){
            smartDoorLock.unlock(PIN);
        }
        assertFalse(smartDoorLock.isLocked());
    }

    @Test
    void tryToLock(){
        smartDoorLock.setPin(PIN);
        smartDoorLock.unlock(PIN);
        smartDoorLock.lock();
        assertTrue(smartDoorLock.isLocked());
    }

    @Test
    void multipleUncorrectPinInsert(){
        smartDoorLock.setPin(PIN);

        for(int i = 1; i < 4; i++){
            smartDoorLock.unlock(UNCORRECT_PIN);
        }
        assertEquals(3, smartDoorLock.getFailedAttempts());
    }

    @Test
    void getBlocked(){
        smartDoorLock.setPin(PIN);

        for(int i = 1; i < 5; i++){
            smartDoorLock.unlock(UNCORRECT_PIN);
        }
        assertTrue(smartDoorLock.isBlocked());
    }

    @Test
    void tryToReset(){
        tryToLock();
        smartDoorLock.reset();
        assertAll(
                () -> assertFalse(smartDoorLock.isLocked()),
                () -> assertFalse(smartDoorLock.isBlocked()),
                () -> assertEquals(0, smartDoorLock.getFailedAttempts())
        );
    }
}
