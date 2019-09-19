import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

	
	public class CallableEg implements Callable<String>{
	
	

		public String call() throws Exception {
			System.out.println(Thread.currentThread().getName() + " Its Running ");
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {

			}
			System.out.println(Thread.currentThread().getName() + " Its Stopped ");
			return "Main is Running";
			
		}
	

	public static void main(String[] args) {
		//CallableEg c = new CallableEg();
		
		CallableEg c1 = new CallableEg();

		
		ExecutorService e = Executors.newFixedThreadPool(1);

		Future<String> f = e.submit(c1);
//		for (Future<String> f : futureList) {
			while(!f.isDone()) {
				System.out.println(Thread.currentThread().getName() + " Its Waiting");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			String s = null;
			try {
				s = f.get();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			} catch (ExecutionException e1) {
				e1.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " Returned Value:" + s);			
//		}
		
	}
}


	


