package rabbit;

import java.util.Scanner;

public class TestJVM {
	
	 public static void method1() {
	        synchronized (String.class) {
	            try {
	                Thread.sleep(2000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            System.out.println("线程a尝试获取integer.class");
	            synchronized (Integer.class) {
	                System.out.println("线程a获取到integer.class");
	            }

	        }
	    }

	    public static void method2() {
	        // 不再获取线程a需要的Integer.class锁。
	        synchronized (String.class) {
	            try {
	                Thread.sleep(2000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            System.out.println("线程b尝试获取Integer.class");
	            synchronized (Integer.class) {
	                System.out.println("线程b获取到Integer.class");
	            }

	        }
	    }


	public static void main(String[] args) {
		
	    XIAOXI xiaoxi = new XIAOXI();
	    xiaoxi.setContent("aaaaa");
	    xiaoxi.setFjbh("aaaaaaa");
	    xiaoxi.setLati("aaaaaaa");
	    System.out.println(xiaoxi);
	   
	        Thread td1 = new Thread(new Runnable() {
	            public void run() {
	            	TestJVM.method1();
	            }
	        });
	        // 线程b
	        Thread td2 = new Thread(new Runnable() {
	            public void run() {
	            	TestJVM.method2();
	            }
	        });

	        td1.start();
	        td2.start();
	        
	        Scanner sc = new Scanner(System.in);
	        int a = sc.nextInt();
	        System.out.println("a = " + a);
	    }
	

}
