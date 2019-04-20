/* Name: Alexander Meade
Course: CNT 4714 Spring 2018
Assignment title: Project 2 – Synchronized, Cooperating Threads Under Locking
Due Date: February 11, 2018
*/
package Bank;

public class bankDeposits implements Runnable {
		private BankAccount mainAccount;
		
		public bankDeposits(BankAccount userAccount) {
			mainAccount = userAccount; 
		}
		
		public void run() {
			try { while(true) {
				mainAccount.deposit(); // to write 
				Thread.sleep(7500);
			} } catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
}
