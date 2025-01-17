/*
 *Class:Cook.java
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

package banket;

public class Cook extends Thread {
    BadPotTwo pot;

    public Cook(BadPotTwo pot) {
        this.pot = pot;
    }

    public void run() {
        while(true) {
            System.out.println(Thread.currentThread().getName() +
                    " would like to fill the pot");
            try {
                Thread.sleep(200);
                pot.fillpot();
            }catch(InterruptedException e) {}
        }
    }
}
