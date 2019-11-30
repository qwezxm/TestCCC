package ccv;

public class T1 implements  Runnable {
    
	public Money money;
	
	public T1(Money money){
		this.money = money;
	}
	
	public void run() {
		int te = 30;
		money.addMoney(te);
		System.out.println(Thread.currentThread().getName()+"--"+money);
	}
	
    
}



