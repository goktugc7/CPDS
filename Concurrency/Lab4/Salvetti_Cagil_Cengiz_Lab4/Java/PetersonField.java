/*Peterson
* Class: PetersonField
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


// The GreedyField class has the Main() method
public class PetersonField {
	public static void main(String[] args) {
		//Initiate the threads
		Flags flags = new Flags();
		Turn turn = new Turn();
		Thread alice = new PetersonNeighbor(flags,turn);
		Thread bob = new PetersonNeighbor(flags,turn);
		//Set names for the threads
		alice.setName("alice");
		bob.setName("bob");
		//Start the threads
		a.start();
		b.start();
	}
}
