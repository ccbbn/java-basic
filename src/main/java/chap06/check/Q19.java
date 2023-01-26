package chap06.check;

import jdk.dynalink.beans.StaticClass;

public class Q19 {
    int balance;
    static final int MIN_BALANCE = 0;
    static final int MAX_BALANCE = 1000000;


    void setBalance(int balance) {
        if ( balance < MIN_BALANCE || balance > MAX_BALANCE) {
            return;}

            this.balance = balance;
    }

    int getBalance() {
        return balance;
    }

}
