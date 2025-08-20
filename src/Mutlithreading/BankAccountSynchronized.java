package src.Mutlithreading;

import src.Mutlithreading.ThreadLifecylce.Bank;

public class BankAccountSynchronized implements Bank {

    private int balance = 100;

    //Intrinsic/Automatic locking mechanism implemented via Synchronized
    public synchronized void withdraw(int amount){
        System.out.printf("%s attempting to withdraw Rs. %d\n", currentThread() , amount);
        if(balance>=amount){
            System.out.printf("%s proceeding with withdrawal\n", currentThread());
            try {
                //to simulate  complex processing
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            balance-=amount;
            System.out.printf("%s withdrawal completed. Available Balance Rs. %d\n", currentThread(), balance);
        }else{
            System.out.printf("%s insufficient balance.\n", currentThread());
        }
    }

    public String currentThread(){
        return Thread.currentThread().getName();
    }
}
