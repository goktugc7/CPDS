/*Peterson
* Class: Flags
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

// Class to represent the flags of neighbors.
// A single Flags object will be shared by both of the neighbors, in order to avoid multiple access problems
// methods are declared as synchronized.
public class Flags {
	
	private boolean flag_alice;
	private boolean flag_bob;
	
	//flags are raised down, initially
	public Flags() {
		flag_alice = false;
		flag_bob = false;
	}
	
	//To control other neighbors flag's status. Parameter is the name of the one who checks.
	public synchronized boolean query_flag(String s) {
		// No sync condition is needed
		if(s.equals("alice")) 
			return flag_bob;
		return flag_alice;
	}
	
	// Set the flag to true. Parameter is the name of the one whose flag is set to true.
	public synchronized void set_true(String s) {
		//no condition synchronization is needed
		if (s.equals("alice"))
			flag_alice = true;
		else
			flag_bob = true;
	}
	
	// Set the flag to true. Parameter is the name of the one whose flag is set to false.
	public synchronized void set_false(String s) {
		//no condition synchronization is needed
		if (s.equals("alice"))
			flag_alice = false;
		else
			flag_bob = false;
	}
}
