package ccv;



public class Thea  {
	
	public static void main(String[] args) {
		final Mydata data = new Mydata();
		for(int i=0;i<2;i++){
			new Thread(new Runnable(){
				public void run(){
					data.add();
				}
			}).start();
			
			new Thread(new Runnable(){
				public void run(){
				    data.dec();
				}
			}).start();
		}
	}

	


}

class Mydata{
	private int j=0;
	public synchronized void add(){
		j++;
		System.out.println("线程"+Thread.currentThread().getName()+"--"+j);
	}
	public synchronized void dec(){
		j--;
		System.out.println("线程"+Thread.currentThread().getName()+"--"+j);
	}
	
}
