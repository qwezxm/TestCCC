package ccv;

public class T2 implements  Runnable {

public Money money;
	
	public T2(Money money){
		this.money = money;
	}
	
	public void run() {
		int te = 10;
		money.decMoney(te);
		System.out.println(Thread.currentThread().getName()+"--"+money);
	}
    
}
