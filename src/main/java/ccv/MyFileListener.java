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
        //System.out.println("��ʼ����Ŀ¼");
    }

    
    @Override
    public void onStop(FileAlterationObserver observer) {
        super.onStop(observer);
        //System.out.println("��������Ŀ¼");
    }

    @Override  
    public void onFileCreate(File file) {  
        System.out.println("�����ļ�����:" + file.getName());  
        String filename = file.getName();
        //TestStoreApi.add(filepath, filename);
    }
    
    @Override  
    public void onFileChange(File file) {  
        System.out.println("�ļ��ı� : " + file.getName());  
    } 
    
    
    public static void monitor(String fileparth) {
        try {
        	
        	// ����۲�����Ҫ�ṩҪ�۲���ļ���Ŀ¼����Ȼ������ϸ��Ϣ��filter
            FileAlterationObserver observer = new FileAlterationObserver(fileparth, new FileFilter() {
                public boolean accept(File pathname) {
                    return true;
                }
            });
            
            MyFileListener listener = new MyFileListener();
            // Ϊ�۲���������������
            observer.addListener(listener);
            // ����Monitor����һ��������λ�Ǻ��룬�Ǽ����ļ�����ڶ����������ǰ�����֮ǰ�Ĺ۲����
            FileAlterationMonitor fileMonitor = new FileAlterationMonitor(1000,
                    new FileAlterationObserver[] { observer });
            // ������ʼ����
            fileMonitor.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
