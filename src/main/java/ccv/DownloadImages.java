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
    
	
	//网页的url
	private String urlString;
	//保存图片的url
	private String savePath;
	
	public DownloadImages() {};
	
	public DownloadImages(String urlString, String savePath) {
		this.urlString = urlString;
		this.savePath = savePath;
	};
	
	public void run() {
		try {
			//调用getNoRepeatImg方法，得到图片url
			String imgUrlStr = getNoRepeatImg(savePath, urlString);
		    
			if(imgUrlStr != null && !imgUrlStr.equals("")){
				// 构造URL
			    URL imgUrl = new URL(imgUrlStr);
			    // 打开连接
			    URLConnection con = imgUrl.openConnection();
			    //设置请求超时为5s
			    con.setConnectTimeout(5*1000);
			    // 输入流
			    InputStream is = con.getInputStream();
			    
			    // 1K的数据缓冲
			    byte[] bs = new byte[1024];
			    // 读取到的数据长度
			    int len;
			    // 输出的文件流
			   File sf=new File(savePath);
			   if(!sf.exists()){
				   sf.mkdirs();
			   }
			   
			   //得到图片的名字，url中最后一个/到？之间的内容
			   String filename = imgUrlStr.substring(imgUrlStr.lastIndexOf("/")+1, imgUrlStr.lastIndexOf("?"));
			   OutputStream os = new FileOutputStream(sf.getPath() + "\\" + filename);
			   // 开始读取
			    while ((len = is.read(bs)) != -1) {
			      os.write(bs, 0, len);
			    }
			    // 完毕，关闭所有链接
			    os.close();
			    is.close();
			}
		} catch (Exception e){
			e.printStackTrace();
	    }
	}
	
	
	//获取网页上的图片
	public static String getImg(String url) {
		String imgSrc = "";
		String src = "";
		String regex = "http://10.1.64.146/(nmcpro|publish)/(www|product)/[0-9]{4}/[0-9]{2}/[0-9]{2}/[A-Z]{2,}/[A-Z0-9_/-/.]{3,}(JPG|jpg)\\?[a-z]{1}=[0-9]{3,}";
		try {
            Document doc = Jsoup.connect(url).get();
            Elements imgs = doc.select("img");
            for (Element element : imgs) {
                 src = element.absUrl("src");
                 //正则匹配网页里的图片
                 if(src.matches(regex)){
                	 imgSrc = src;
                 }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		return imgSrc;
	}
	
	//判断图片是否一致
	//新文件产生则返回，存在则返回空
	public static String getNoRepeatImg (String savePath, String url){
		String imgUrlStr = getImg(url);
		String imgname = imgUrlStr.substring(imgUrlStr.lastIndexOf("/")+1, imgUrlStr.lastIndexOf("?"));
		
		File dir = new File(savePath);
		File[] files = dir.listFiles();
		//判断文件是否存在，
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


