package aaa;

public class TestThread  {
	
	
	
	public static void main(String[] args) throws InterruptedException{
		System.out.println("start");
		Thread t = new Thread(){
			
			@Override
			public void run(){
			    for (int i = 0; i < 10; i++){
			    	System.out.println("iµÄÖµÊÇ" + i);
			    }
			    System.out.println(Thread.currentThread().getName());
			}
			
		};
		t.start();
		System.out.println(Thread.currentThread().getName());
		t.join();
		System.out.println(Thread.currentThread().getName());
		System.out.println("end");
		System.out.println(Thread.currentThread().getName());
		
		
		
	}
}
