/*Field Program
*
* Class: Neighbor
*
*Name: Isadora
*Surname: Salvetti
*
*Name: Mehmet Fatih
*Surname: Cagil
*
*Name: Goktug
*Surname: Cengiz
*
*/

package greedyfield;

// GreedyNeighbor class implements the behavior of each one of the neighbors. (with no stress)
// Extends the thread class because they operate concurrently
public class GreedyNeighbor extends Thread {
	private Flags flags;	

	public Neighbor(Flags flags) {
		this.flags = flags;
	}
	
	
	//To model greedy behavior we sleep after raising the flag
	public void run() {
		while (true) {
			try {
				
				String name = Thread.currentThread().getName();	
				System.out.println("try again, my name is: "+ name);
				
				flags.set_true(name);
				Thread.sleep((int)(200*Math.random()));
				
				if (!flags.query_flag(name)) {	//Check the other neighbor, if the field is empty, enter.
					System.out.println(name + " enters");
					Thread.sleep(400);
					System.out.println(name + " exits");
				}
				
				Thread.sleep((int)(200*Math.random()));

				flags.set_false(name);		// Lower the flag when you exit the field.
			}catch (InterruptedException e) {};
		}
	}
}