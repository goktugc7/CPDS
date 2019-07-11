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

package field;

// Neighbor class implements the behavior of each one of the neighbors. (with no stress)
// Extends the thread class because they operate concurrently
public class Neighbor extends Thread {
	private Flags flags;	

	public Neighbor(Flags flags) {
		this.flags = flags;
	}
	
	
	//In order to avoid being greedy, neoghbors wait before requrestion the access to the field.
	public void run() {
		while (true) {
			try {
				
				String name = Thread.currentThread().getName();	
				System.out.println("try again, my name is: "+ name);
				
				Thread.sleep((int)(200*Math.random()));
				
				flags.set_true(name);	

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