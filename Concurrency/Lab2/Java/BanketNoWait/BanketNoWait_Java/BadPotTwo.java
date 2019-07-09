/*
 *Class:BadPotTwo.java
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

public class BadPotTwo {
    private int servings = 0;
    private int capacity;

    public BadPotTwo(int capacity) {
        this.capacity = capacity;
    }

    /*
    Synchronize condition: At least one serving should be available, otherwise
    go for a walk(instead of waiting) and call the method again.
     */

    public synchronized void getServing() throws InterruptedException{

        if(servings == 0) {
            System.out.println(Thread.currentThread().getName() + " goes for a walk");
        }
        else {
            Thread.sleep(200);
            --servings;
            System.out.println(Thread.currentThread().getName() + " is served");
            print_servings();
        }
    }
    /*
    Synchronize condition: Fill the pot when its empty,
    otherwise go for a walk then call the method again.
     */
    public synchronized void fillpot() throws InterruptedException{

        if(servings > 0) {
            System.out.println(Thread.currentThread().getName() + " goes for a walk");
        }
        else{
            Thread.sleep(200);
            System.out.println(Thread.currentThread().getName() + " is filling the pot...");
            servings = capacity;
            // Wake up threads in Waiting set in order to assure runnable savages
            print_servings();
        }
    }

    // For trace purposes
    public synchronized void print_servings() {
        System.out.println("Servings in the pot: " + servings);
    }
}
