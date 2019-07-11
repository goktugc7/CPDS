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

package field;


// The Field class has the Main() method
public class Field {
	public static void main(String[] args) {
		//Initiate the threads
		Flags flags = new Flags();
		Thread alice = new Neighbor(flags);
		Thread bob = new Neighbor(flags);
		//Set names for the threads
		alice.setName("alice");
		bob.setName("bob");
		//Start the threads
		a.start();
		b.start();
	}
}
