//class for threaded prime number testing
//no inheritance issues so using the simple form of thread creation
class testRange extends Thread {
   //static long possPrime;
   static double possPrime;
	long from, to; //test range for a thread
	//double from, to; //test range for a thread
	//constructor
	//record the number to be tested and the range to be tried
	testRange(int argFrom, double argpossPrime) {
	    possPrime = argpossPrime;
		 if (argFrom ==0) from = 2; else from = argFrom;
		 to=argFrom+99;
	}
	//implementation of run
	public void run() {
	   for (double i=from; i <= to && i<possPrime; i++) {
		    if (possPrime % i == 0) {
			     //i divides possPrime exactly
				  System.out.println("factor " + i + " found by thread " + getName() );
				  break;  //exit for loop immediately
			 }
			 yield(); //suspend thread
		}
   }
}