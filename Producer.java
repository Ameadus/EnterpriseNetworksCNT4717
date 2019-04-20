// Producer's run method stores the values 1 to 10 in buffer.
import java.util.Random;

public class Producer implements Runnable 
{
   private static Random generator = new Random();
   private Buffer sharedLocation; // reference to shared object
   // constructor
   public Producer( Buffer shared )
   {
      sharedLocation = shared;
   } // end Producer constructor
   // store values from 1 to 10 in sharedLocation
   public void run()
   {
      int sum = 0;
      for ( int count = 1; count <= 10; count++ ) 
      {  
         try // sleep 0 to 3 seconds, then place value in Buffer
         {
           Thread.sleep( generator.nextInt( 30 ) ); // sleep thread   
            sharedLocation.set( count ); // set value in buffer
            sum += count; // increment sum of values
           // uncomment for unsync version - 
           // System.out.printf( "\t%2d\n", sum );
         } // end try
         // if sleeping thread interrupted, print stack trace
         catch ( InterruptedException exception ) 
         {
            exception.printStackTrace();
         } // end catch
      } // end for

      System.out.printf( "\n%s\n%s\n", "Producer done producing.", 
         "  Terminating Producer. " );
		System.out.println("Producer produced values totaling: " + sum +"\n");
   } // end method run
} // end class Producer