/* Name: Alexander Meade
Course: CNT 4714 Spring 2018
Assignment title: Project 2 – Synchronized, Cooperating Threads Under Locking
Due Date: February 11, 2018
*/
package Bank;

public class runThread {

	public static void main(String[] args) {
		BankAccount myAccount = new BankAccount(); //baccount object 
		//print output  formatter 
		System.out.printf("Deposit Threads\t\t\tWithdrawl Threads\t\tAccount Balance\t\t\t\n");
        System.out.printf("---------------\t\t\t-----------------\t\t----------------\t\t\t\n");  
        
        //thread creation
        bankDeposits dep = new bankDeposits(myAccount);
        bankWithdrawls wit = new bankWithdrawls(myAccount);
        //init threads 3 deposit 5 withdrawl 
        Thread dep1 = new Thread(dep, "1");
        Thread dep2 = new Thread(dep, "2");
        Thread dep3 = new Thread(dep, "3");
        Thread dep4 = new Thread(dep, "4");
        
        Thread wit1 = new Thread(wit, "1");
        Thread wit2 = new Thread(wit, "2");
        Thread wit3 = new Thread(wit, "3");
        Thread wit4 = new Thread(wit, "4");
        Thread wit5 = new Thread(wit, "5");
        Thread wit6 = new Thread(wit, "6");
        
        //start up threads 
        dep1.start();
        wit1.start();
        dep2.start();
        wit2.start();
        dep3.start();
        wit3.start();
        wit4.start();
        wit5.start();
        dep4.start();
        wit6.start();
        
	}
}
