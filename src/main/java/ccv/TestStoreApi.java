package ccv;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestStoreApi {
	
	public static void add(String filepath, String filename){
		
		//��ȡ����
		Matcher slashMatcher = Pattern.compile("_").matcher(filename);
	    int mIdx = 0;
	    int startIndex = 0;
	    int endIndex = 0;
	    while(slashMatcher.find()) {
	       mIdx++;
	       //��"_"���ŵ��Ĵγ��ֵ�λ��
	       if(mIdx == 4) {
	    	   startIndex = slashMatcher.start();
	       } 
	       if(mIdx == 5) {
	    	  endIndex = slashMatcher.start();
	       }
	    }
	    String str = filename.substring(startIndex,endIndex);
		
		
		//��ȡʱ��
		String tim = filename.substring(filename.lastIndexOf("_")+1, filename.lastIndexOf("_")+15);

		//Ҫ����
	    String elements = "MIDDLEFILEID,PROCESSUNIT,FILE_NAME,Datetime,P_TITLE";
	    //����
	    String[] inArray2D = new String[] {"", "610000", filepath +"\\"+ filename, tim, str};
		 //����
	    String titles = "EWPF2";
	    //������
	    String p_unit = "CCS2";
	    //ʹ�÷�
	    String u_unit = "CCS2";
	    String[] strings = Arrays.copyOfRange(inArray2D, 0, inArray2D.length);
	    RequestInfo a = StoreApi.insertFileToStore("SEVP_MODI_MPDT_ANEV_SJFC", elements,
	            strings, "CCS2", titles, p_unit, u_unit);
	    System.out.println(a.errorCode);
	    System.out.println(a.errorMessage);
	}
}
