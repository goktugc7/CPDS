/*
 *Class:Person.java
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
import java.util.Random;

/*
Person class
Class to represent Bob & Alice, each of them will run as individual threads.
A random generator is used to determine the action(deposit-withdraw) and amount of the action.
 */
public class Person extends Thread {

    Account account;
    String name;
    Random rand = new Random(999);

    /*
    Constructor, name of the person is also name of the thread.
     */
    public Person(String name, Account acc) {
        this.name = name;
        this.setName(name);
        this.account = acc;
    }

    public void run() {
        int amount = -1;
        while(true) {
            amount = rand.nextInt(1000);
            if (!rand.nextBoolean()){
                System.out.println(this.name + " wants to deposit " + amount + ".");
                try{
                    sleep(200);
                    account.deposit(amount);
                }catch (InterruptedException e) {}
            }
            else{
                System.out.println(this.name + " wants to withdraw " + amount + ".");
                try{
                    sleep(200);
                    account.withdraw(amount);
                }catch (InterruptedException e){}
            }
        }
    }
}
