/*Peterson
*
* Class: PetersonNeighbor
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

package peterson;

// GreedyNeighbor class implements the behavior of each one of the neighbors. (with no stress)
// Extends the thread class because they operate concurrently
public class PetersonNeighbor extends Thread {
	private Flags flags;
	private Turns turn;	

	public PetersonNeighbor(Flags flags, Turn turn) {
		this.flags = flags;
		this.turn = turn;
	}
	
	
	//To model greedy behavior we sleep after raising the flag
	public void run() {
		while (true) {
			try {
				
				String name = Thread.currentThread().getName();	
				System.out.println("try again, my name is: "+ name);
				
				flags.set_true(name);
				turn.pass(name); //pass the turn to neighbor
				//Sleep after flag and turn, to follow greedy
				Thread.sleep((int)(200*Math.random()));
	
				//Wait while its other neighbors turn and their flag is up			
				while (!flags.query_flag(name) && !turn.query_turn(name)) {}
	
				System.out.println(name + " enters");
				Thread.sleep(400);
				System.out.println(name + " exits");

				Thread.sleep((int)(200*Math.random()));

				flags.set_false(name);		// Lower the flag when you exit the field.
			}catch (InterruptedException e) {};
		}
	}
}