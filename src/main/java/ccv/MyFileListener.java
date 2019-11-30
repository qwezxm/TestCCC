package ccv;

import java.io.File;
import java.io.FileFilter;

import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

public class MyFileListener extends FileAlterationListenerAdaptor implements Runnable{
	
	private String filepath;
	
	public MyFileListener() {};
   
	public MyFileListener(String filepath) {
		this.filepath = filepath;
	};
	
	public void run() {
		monitor(filepath);
	}
	
	@Override
    public void onStart(FileAlterationObserver observer) {
        super.onStart(observer);
        //System.out.println("开始监听目录");
    }

    
    @Override
    public void onStop(FileAlterationObserver observer) {
        super.onStop(observer);
        //System.out.println("结束监听目录");
    }

    @Override  
    public void onFileCreate(File file) {  
        System.out.println("有新文件产生:" + file.getName());  
        String filename = file.getName();
        //TestStoreApi.add(filepath, filename);
    }
    
    @Override  
    public void onFileChange(File file) {  
        System.out.println("文件改变 : " + file.getName());  
    } 
    
    
    public static void monitor(String fileparth) {
        try {
        	
        	// 构造观察类主要提供要观察的文件或目录，当然还有详细信息的filter
            FileAlterationObserver observer = new FileAlterationObserver(fileparth, new FileFilter() {
                public boolean accept(File pathname) {
                    return true;
                }
            });
            
            MyFileListener listener = new MyFileListener();
            // 为观察对象添加收听对象
            observer.addListener(listener);
            // 配置Monitor，第一个参数单位是毫秒，是监听的间隔；第二个参数就是绑定我们之前的观察对象。
            FileAlterationMonitor fileMonitor = new FileAlterationMonitor(1000,
                    new FileAlterationObserver[] { observer });
            // 启动开始监听
            fileMonitor.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
