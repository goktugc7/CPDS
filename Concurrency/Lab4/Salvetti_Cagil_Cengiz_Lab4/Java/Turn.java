/*Peterson
*
* Class: Turn
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

//Class to implement the turn concept, which will be passes as a parameter to threads
//This class can be integrated into Flags, but for both following the FSP and Java's Object Oriented style
//it is better to create another class.
public class Turn{

	String turn;

	public Turn(){
		this.turn = "-1";
	}
	public Turn(String str){
		this.turn = str;
	}


	//learn whose turn is that
	public synchronized boolean query_turn(String name){
		if (this.turn.equals("-1") || this.turn.equals(name))
			return true;
		else 
			return false;
	}

	//pass the turn to other thread(neighbor)
	public synchronized void pass(String name){
		if(name.equals("bob"))
			this.turn = "alice";
		else
			this.turn = "bob";
	}
}