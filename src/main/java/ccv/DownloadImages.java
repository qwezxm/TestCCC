package ccv;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DownloadImages implements Runnable {
    
	
	//��ҳ��url
	private String urlString;
	//����ͼƬ��url
	private String savePath;
	
	public DownloadImages() {};
	
	public DownloadImages(String urlString, String savePath) {
		this.urlString = urlString;
		this.savePath = savePath;
	};
	
	public void run() {
		try {
			//����getNoRepeatImg�������õ�ͼƬurl
			String imgUrlStr = getNoRepeatImg(savePath, urlString);
		    
			if(imgUrlStr != null && !imgUrlStr.equals("")){
				// ����URL
			    URL imgUrl = new URL(imgUrlStr);
			    // ������
			    URLConnection con = imgUrl.openConnection();
			    //��������ʱΪ5s
			    con.setConnectTimeout(5*1000);
			    // ������
			    InputStream is = con.getInputStream();
			    
			    // 1K�����ݻ���
			    byte[] bs = new byte[1024];
			    // ��ȡ�������ݳ���
			    int len;
			    // ������ļ���
			   File sf=new File(savePath);
			   if(!sf.exists()){
				   sf.mkdirs();
			   }
			   
			   //�õ�ͼƬ�����֣�url�����һ��/����֮�������
			   String filename = imgUrlStr.substring(imgUrlStr.lastIndexOf("/")+1, imgUrlStr.lastIndexOf("?"));
			   OutputStream os = new FileOutputStream(sf.getPath() + "\\" + filename);
			   // ��ʼ��ȡ
			    while ((len = is.read(bs)) != -1) {
			      os.write(bs, 0, len);
			    }
			    // ��ϣ��ر���������
			    os.close();
			    is.close();
			}
		} catch (Exception e){
			e.printStackTrace();
	    }
	}
	
	
	//��ȡ��ҳ�ϵ�ͼƬ
	public static String getImg(String url) {
		String imgSrc = "";
		String src = "";
		String regex = "http://10.1.64.146/(nmcpro|publish)/(www|product)/[0-9]{4}/[0-9]{2}/[0-9]{2}/[A-Z]{2,}/[A-Z0-9_/-/.]{3,}(JPG|jpg)\\?[a-z]{1}=[0-9]{3,}";
		try {
            Document doc = Jsoup.connect(url).get();
            Elements imgs = doc.select("img");
            for (Element element : imgs) {
                 src = element.absUrl("src");
                 //����ƥ����ҳ���ͼƬ
                 if(src.matches(regex)){
                	 imgSrc = src;
                 }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		return imgSrc;
	}
	
	//�ж�ͼƬ�Ƿ�һ��
	//���ļ������򷵻أ������򷵻ؿ�
	public static String getNoRepeatImg (String savePath, String url){
		String imgUrlStr = getImg(url);
		String imgname = imgUrlStr.substring(imgUrlStr.lastIndexOf("/")+1, imgUrlStr.lastIndexOf("?"));
		
		File dir = new File(savePath);
		File[] files = dir.listFiles();
		//�ж��ļ��Ƿ���ڣ�
		for (File file : files) {
			
			if(imgname.equals(file.getName())){
				return "";
			}
		}
		
		if(imgname == null || imgname.equals("")){
			return "";
		} else {
			return imgUrlStr;
		}
	}
}


