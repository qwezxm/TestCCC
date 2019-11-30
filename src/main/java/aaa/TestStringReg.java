package aaa;

import java.util.Scanner;

public class TestStringReg {
    
	
	public static void main(String[] args) {
		String reg = "http://10.1.64.146/publish/www/[0-9]{4}/[0-9]{2}/[0-9]{2}/[A-Z]{2,}/[A-Z0-9_/-/.]{3,}JPG";
		String str = "http://10.1.64.146/publish/www/2019/10/14/STFC/SEVP_NMC_STFC_SFER_ER24_ACHN_L88_P9_20191014070002400.JPG";
		
		if (str.matches(reg)) {
			System.out.println("输入的数据格式正确！");
		}  else {
			System.out.println("输入的数据格式不正确！！！");
		}
		
		
		
	}
	

}
