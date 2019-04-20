//driver class to demonstrate threaded prime number tester
public class testPrime {
   public static void main (String s[]) {
	    //number to be tested for primality is entered as a command line argument
		 //examples: 2048 is not prime, 5557 is prime, 6841 is prime, 6842 is not prime
		 //long possPrime = Long.parseLong(s[0]);
	    //double possPrime = Double.parseDouble(s[0]);
	   long possPrime=5557;
	   System.out.println("Checking primeness of: " + possPrime);
	   System.out.println();
		 int centuries = (int) (possPrime/100) + 1;
		 for (int i=0; i<centuries;i++) {
		      new testRange(i*100, possPrime).start();
		 }
		 System.out.println("All threads complete...termination!");
	}
}