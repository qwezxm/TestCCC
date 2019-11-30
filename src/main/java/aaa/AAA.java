package aaa;

public class AAA  extends Thread{
	
	public void run(){
		System.out.println("aaa");
		
	}

	public static void main(String[] args) {
		AAA aa = new AAA();
		aa.start();
		aa.wait();
		Map<String, MappedStatement> ss = 

	}

}
