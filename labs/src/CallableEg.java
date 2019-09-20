

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableEg{
	
	 public class MyCallable implements Callable<String> {
		@Override
		public String call() throws Exception {
			int x=1;
			System.out.println(Thread.currentThread().getName() + " Its Running ");
			try {
				Thread.sleep(1000);
				for(int i=0;i<20;i++) {
				x++;
				}
			} catch (InterruptedException e) {
			
			}
			System.out.println(Thread.currentThread().getName() + " " + x);
			return "Main is running";
			 
		}
	
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CallableEg eg = new CallableEg();
		Callable<String> c1 = eg.new MyCallable();
		ExecutorService e = Executors.newFixedThreadPool(1);
		Future<String> f = e.submit(c1);
		while(!f.isDone()) {
			System.out.println(Thread.currentThread().getName() + " -->Waiting");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		
		System.out.println(f.get());
	
		
	}
}




	


