//Class to illustrate threads created via Runnable interface
public class TestRunnable {
  // Create threads
  Thread printA = new Thread(new PrintChar('a', 20));
  Thread printB = new Thread(new PrintChar('b', 20));
  Thread print20 = new Thread(new PrintNum(20));

  public static void main(String[] args) {
    new TestRunnable();
  }

  public TestRunnable() {
    // Start threads
    print20.start();
    printA.start();
    printB.start();
  }

  // The thread class for printing a specified character in specified times
  class PrintChar implements Runnable {
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
  class PrintNum implements Runnable {
    private int lastNum;

    // Construct a thread for print 1, 2, ... i 
    public PrintNum(int n) {
      lastNum = n;
    }

    // Tell the thread how to run 
    public void run() {
      for (int i = 1; i <= lastNum; i++){
        System.out.print(" " + i);
		  try {
		        if (i == 10) printA.join();
	     }
		  catch (InterruptedException ex) { }
		}
    }
  }
}//end class TestRunnable


