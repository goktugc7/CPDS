/*Field Program
* Class: Field
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


// The GreedyField class has the Main() method
public class Field {
	public static void main(String[] args) {
		//Initiate the threads
		Flags flags = new Flags();
		Thread alice = new GreedyNeighbor(flags);
		Thread bob = new GreedyNeighbor(flags);
		//Set names for the threads
		alice.setName("alice");
		bob.setName("bob");
		//Start the threads
		a.start();
		b.start();
	}
}
