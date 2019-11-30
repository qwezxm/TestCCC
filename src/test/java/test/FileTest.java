package test;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;


import ccv.DownloadImages;
import ccv.FileUtils;
import ccv.MyFileListener;


public class FileTest {
    
	@Test
	public void createFile() {
		FileUtils.createFile("f:\\bb\\a.txt");
	}
	@Test
	public void moveFile() {
		FileUtils.moveFile("f:\\bb\\a.txt", "f:\\aa");
	}
	@Test 
	public void download() throws Exception {
		//DownloadImage.download("http://10.1.64.146/publish/www/2019/10/12/STFC/SEVP_NMC_STFC_SFER_ER24_ACHN_L88_P9_20191012070002400.JPG", "F:\\test\\new");
	}
	
	//http://10.1.64.146/publish/www/2019/10/12/STFC/SEVP_NMC_STFC_SFER_ER24_ACHN_L88_P9_20191012070002400.JPG?v=1570845129776
    @Test 
    public void getImg (){
    	String url = "http://10.1.64.146/npt/product/show/38198/38199";
    	String src = DownloadImages.getImg(url);
    	System.out.println(src);
    }
    
    //时间截取14位
    @Test 
    public void match(){
    	String url ="http://10.1.64.146/nmcpro/produ/2019/10/16/STFC/SEVP_NMC_STFC_SFER_ER6T24_ACHN_L88_P9_20191016000002406.JPG?v=1571178247358";
    	String regex = "http://10.1.64.146/(nmcpro|publish)/(www|product)/[0-9]{4}/[0-9]{2}/[0-9]{2}/[A-Z]{2,}/[A-Z0-9_/-/.]{3,}(JPG|jpg)\\?[a-z]{1}=[0-9]{3,}";
//    	String url ="http://10.1.64.146/publish/www/2019/10/15/STFC/SEVP_NMC_STFC_SFER_ER24_ACHN_L88_P9_20191015070002400.jpg";
//    	String regex = "http://10.1.64.146/publish/www/[0-9]{4}/[0-9]{2}/[0-9]{2}/[A-Z]{2,}/[A-Z0-9_/-/.]{3,}jpg";
    	boolean ss = url.matches(regex);
    	System.out.println(ss);
    }
   @Test 
    public void testsubstring(){
//    	String filename = "SEVP_NMC_STFC_SFER_ER24_ACHN_L88_P9_20191016010004800.jpg";
//    	String tim = filename.substring(filename.lastIndexOf("_")+1, filename.lastIndexOf("_")+15);
//    	System.out.println(tim+"---"+tim.length());
	   String path = "F:\\test\\now";
	   String imgUrlStr = "http://10.1.64.146/publish/www/2019/10/16/STFC/SEVP_NMC_STFC_SFER_ER24_ACHN_L88_P9_20191016020016800.JPG?v=1571189344393";
	   String filename = imgUrlStr.substring(imgUrlStr.lastIndexOf("/") + 1, imgUrlStr.lastIndexOf("?"));
	   String str = path+"\\"+filename;
	   System.out.println(filename);
	   System.out.println(path+"\\"+filename);
	   File file = new File(str);
	   System.out.println(file.getPath()+"---"+file.getName());
    	
    }
   
   
   		
   
	
}
