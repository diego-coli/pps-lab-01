package tdd;

public class SimpleSmartDoorLock implements SmartDoorLock{

    private Integer pin;
    private boolean lockedState;
    private boolean blockedState;
    private int failedAttempts;
    private final int MAX_ATTEMPTS = 3;

    public SimpleSmartDoorLock(){
        this.pin = null;
        this.lockedState = false;
        this.blockedState = false;
        this.failedAttempts = 0;
    }

    @Override
    public void setPin(int pin) {
        if(!isLocked() && !isBlocked()){
            if(pin < 999 || pin > 9999){
                throw new IllegalStateException("\nERR: new PIN should be 4-digit!");
            }
            else{
                this.pin = pin;
                this.failedAttempts = 0;
                lock();
            }
        }
        else{
            throw new IllegalStateException("\nERR: Can't set a new PIN, unlock or reset first!");
        }
    }

    @Override
    public void unlock(int pin){
        if(!isBlocked()){
            if(this.pin == pin){
                this.lockedState = false;
                this.failedAttempts = 0;
            }
            else{
                this.failedAttempts++;
                if(this.failedAttempts > 3){
                    blockedState = true;
                }
            }
        }
    }

    @Override
    public void lock(){
        if(this.pin == null){
            throw new IllegalStateException("ERR: Can't lock, set a new PIN first!");
        }
        else{
            this.lockedState = true;
        }
    }

    @Override
    public boolean isLocked(){
        return lockedState;
    }

    @Override
    public boolean isBlocked(){
        return blockedState;
    }

    @Override
    public int getMaxAttempts(){
        return MAX_ATTEMPTS;
    }

    @Override
    public int getFailedAttempts(){
        return failedAttempts;
    }

    @Override
    public void reset(){
        this.lockedState = false;
        this.blockedState = false;
        this.pin = null;
        this.failedAttempts = 0;
    }
}
