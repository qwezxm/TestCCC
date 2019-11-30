package ccv;

public class Money {

	private int money;
	
	
	
	public Money(int money){
		this.money = money;
	};
	
	public synchronized void addMoney(int cc){
		money += cc;
	}
	public synchronized void decMoney(int cc){
		money -= cc;
	}
	
	public static void main(String[] args) throws InterruptedException {
		Money money = new Money(100);
		new Thread(new T1(money)).start();
		new Thread(new T2(money)).start();
		Thread.sleep(1000);
		System.out.println(Thread.currentThread().getName()+"--"+money);
	}

	@Override
	public String toString() {
		return "Money [money=" + money + "]";
	}
	
	
	
}
