/*
 *Class:Company.java
 *
 *Name: Isadora
 *Surname: Salvetti
 *
 *Name: Mehmet Fatih
 *Surname: Cagil
 *
 *Name: Goktug
 *Surname: Cengiz
 */
package savingAccount;
/*
Recommended solution to avoid execution to get stuck when the balance is not enough
to satisfy withdraw orders of Alice and Bob.
This class is acts like a person, only difference is it tries to deposit a fixed amount (250)
and it doesnt withdraw money at all.
 */
public class Company extends Thread{

    String name;
    Account account;
    int fixedAmount = 250;


    public Company(String name,Account acc){
        this.name = name;
        this.setName(name);
        this.account = acc;
    }

    /*
    Tries to deposit fixed amount to the account.
    After depositing the money, it goes to sleep for 3 seconds to allow other threads
    to get stuck possibly.
     */
    public void run(){
        while(true){
            System.out.println(this.name + " wants to deposit 250.");
            try{
                sleep(300);
                account.deposit(fixedAmount);
                sleep(3000);
            } catch (InterruptedException e){}
        }
    }

}
