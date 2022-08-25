/* This is java program in which we used Synchronized method in multithreading 
    @Priyanshu */


package first.bank;


class counter{
	int i=0;
  public synchronized void increment ()
 {
	i++;
 } 
}

public class synchronization {

	public static void main(String[] args) throws InterruptedException {
		
	  counter ps=new counter();
	  Thread t1=new Thread () {
			  
		  public void run () {
			  
			
			for(int a=1;a<=1000;a++)
				ps.increment();
		  } 
		 };
		  Thread t2=new Thread () {
			  
			  public void run () {
				  
				for(int a=1;a<=1000;a++)
			    ps.increment();
			  } 
			 }; 
			 t1.start();
			 t2.start();
			 
			 t1.join();
			 t2.join();
			 
			 System.out.println(ps.i);
	  
	}

}
