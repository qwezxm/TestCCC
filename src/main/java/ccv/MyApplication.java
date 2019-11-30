package ccv;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MyApplication {
    
	public static void main(String[] args) {
		
		String urlString = "http://10.1.64.146/npt/product/show/38199/38199";
		String savePath = "F:\\test\\now";
		String filepath = "F:\\test\\now";
		
		DownloadImages task = new DownloadImages(urlString, savePath);
		MyFileListener task2 = new MyFileListener(filepath);
		
		ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(2);
		scheduled.scheduleAtFixedRate(task, 0, 3, TimeUnit.SECONDS);
		scheduled.submit(task2);
		
	}
}

