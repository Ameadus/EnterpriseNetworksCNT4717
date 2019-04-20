/* Name: Alexander Meade
Course: CNT 4714 Spring 2018
Assignment title: Project 2 – Synchronized, Cooperating Threads Under Locking
Due Date: February 11, 2018
*/
package Bank;

import java.util.*;

public class randomTransaction {

	//if action is true money is deposited false is withdrawl
	public static int newNumber(boolean action) {
		int randNum = 0; 

		if(action == true) {
			randNum = randRange(1,200); //range of 1 to 200$ 
			return randNum;
		}
		else {
			randNum = randRange(1,50); //range of 1 to 50$
			return randNum;
		}
	}
	//make a rand int in the number range 
	private static int randRange(int low, int high) {
		Random randGenerator = new Random();
		int rand = 0; 
		while( low >= rand || high <= rand ) {
			rand = randGenerator.nextInt();
		}
		return rand;
	}
	
}
