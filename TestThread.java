
//Class to generate threads by extending the Thread class
//TestThread - example of extending the Thread class

public class TestThread {
	  // Main method 
	  public static void main(String[] args) {
	    // Create threads
	    PrintChar printA = new PrintChar('a', 20);
	    PrintChar printB = new PrintChar('b', 20);
	    PrintNum  print20 = new PrintNum(20);

	    // Start threads
        print20.start();// try {print20.sleep(5000);}catch(InterruptedException e){}
        printA.start(); // try {printA.sleep(5000);} catch(InterruptedException e) {}
	    printB.start();
	    
	  }
	}

	// The thread class for printing a specified character a specified times
	class PrintChar extends Thread {
	  private char charToPrint;  // The character to print
	  private int times;  // The number of times to repeat the character

	  // Construct a thread with specified character and number of times to print the character
	  public PrintChar(char c, int t) {
	    charToPrint = c;
	    times = t;
	  }

	  // Override the run() method to tell the system what the thread will do
	  public void run() {
	    for (int i = 0; i < times; i++)
	      System.out.print(charToPrint);
	  }
	}

	// The thread class for printing a number n a specified number of times
	class PrintNum extends Thread {
	  private int lastNum;

	  // Construct a thread for print 1, 2, ... i 
	  public PrintNum(int n) {
	    lastNum = n;
	  }

	  // Tell the thread how to run 
	  public void run() {
	    for (int i = 1; i <= lastNum; i++)
	      System.out.print(" " + i);
	  }
	}//end class TestThread




