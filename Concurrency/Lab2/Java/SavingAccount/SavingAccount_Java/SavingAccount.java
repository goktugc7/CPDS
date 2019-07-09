/*
 *Class:SavingAccount.java
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

public class SavingAccount {
    public static void main(String[] args) {

        // Instance creation.
        Account account = new Account();
        Thread alice = new Person("Alice", account);
        Thread bob = new Person( "Bob", account);
        Thread mb = new Company("Company",account);

        // Start the threads
        alice.start();
        bob.start();
        mb.start();
    }
}
