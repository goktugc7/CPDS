/*
 *Class:Account.java
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

/*Account class. Possible actions are synchronized and follows the wait & notify schema.
*/
public class Account {
    int balance = 0;

    /*
    Method to deposit the money. It has declared as synchronized to avoid multiple access problems
     to variable "balance".
    No conditions to deposit money, so there are not any waiting states.
    Notifies all threads when deposit is done.
     */
    public synchronized void deposit(int amount){
        System.out.println(Thread.currentThread().getName() + " deposited " + amount + " ." );
        balance = balance+ amount;
        notifyAll();
    }

    /*
    Method to withdraw money. It is synchronized and follows the wait & notify.
    If there is enough money in the account, it allows to withdraw; otherwise will wait until
    enough balance is available.
     */
    public synchronized void withdraw( int amount) throws InterruptedException{
        while (balance < amount){
            System.out.println(Thread.currentThread().getName() + " wanted to withdraw " + amount + " but balance is not enough.");
            wait();
        }
        balance = balance - amount;
        System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ".");
        System.out.println("Balance is " + balance + ".");
    }
}
