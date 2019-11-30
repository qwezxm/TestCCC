package fiel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DufILE {
	
	public static void main(String[] args) {

		String filename = "F:\\fwetgh\\index_109.txt";
		String filename2 = "F:\\fwetgh\\index_111.txt";
		
		List<String> list2 = new ArrayList<String>();
		
		List<String> inlist1 = new ArrayList<String>();
		List<String> inlist2 = new ArrayList<String>();
		try {

			FileInputStream in = new FileInputStream(filename);
			InputStreamReader inReader = new InputStreamReader(in, "UTF-8");
			BufferedReader bufReader = new BufferedReader(inReader);
			
			FileInputStream in2 = new FileInputStream(filename2);
			InputStreamReader inReader2 = new InputStreamReader(in2, "UTF-8");
			BufferedReader bufReader2 = new BufferedReader(inReader2);
			String line = null;
			int i = 0;
			
			HashMap<String, List<String>> map = new HashMap<String, List<String>>();
			List<String> list = new ArrayList<String>();
			
			while ((line = bufReader.readLine()) != null) {
				if(line.startsWith("[") && line.endsWith("]")){
					String sss = line.substring(line.indexOf("[")+1,line.indexOf("]"));
				    map.put(sss, null);
				} else if (line.equals("NNNN")) {
					continue;
				} else if (line.startsWith("#")) {
					continue;
				} else {
					list.add(line);
				}
				
				
			}
			
			while ((line = bufReader2.readLine()) != null) {
				if (line.startsWith("[") && line.endsWith("]")){
					list2.add(line);
				} 
				i++;
			}
			
			for() {
				
			}
			
			for (String ss : list){
				String sss = ss.substring(ss.indexOf("[")+1,ss.indexOf("]"));
				System.out.println(sss);
			}
			
			
			
			bufReader.close();
			inReader.close();
			in.close();
			bufReader2.close();
			inReader2.close();
			in2.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("¶ÁÈ¡" + filename + "³ö´í£¡");
		}

	}

}
