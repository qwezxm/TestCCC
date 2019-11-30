package aaa;

import java.util.ArrayList;
import java.util.List;

public class QQa {

	public static void main(String[] args) {
		String[] str = new String[9];
		
		str[0]="Z_RADA_C_BABJ_20191106055716_P_ACHN.OHP000.20191106.054800.latlon";
		str[1]="Z_RADA_C_BABJ_20191106055415_P_ACHN.OHP000.20191106.054200.latlon";
		str[2]="Z_RADA_C_BABJ_20191106055115_P_ACHN.OHP000.20191106.054200.latlon";
		str[3]="Z_RADA_C_BABJ_20191106053545_P_ACHN.OHP000.20191106.052400.latlon";
		str[4]="Z_RADA_C_BABJ_20191106054815_P_ACHN.OHP000.20191106.053600.latlon";
		str[5]="Z_RADA_C_BABJ_20191106054516_P_ACHN.OHP000.20191106.053600.latlon";
		str[6]="Z_RADA_C_BABJ_20191106054210_P_ACHN.OHP000.20191106.053000.latlon";
		str[7]="Z_RADA_C_BABJ_20191106053900_P_ACHN.OHP000.20191106.053000.latlon";
		str[8]="Z_RADA_C_BABJ_20191106052313_P_ACHN.OHP000.20191106.051200.latlon";

		
		
		List<String> list = new ArrayList<String>();
		
		for(int i=0;i<9;i++){
            list.add(str[i]);			
		}
		
		
		for(String ss : list){
			System.out.println(""+"select count(*) from RADA_CHN_DOR_L3_FILE_TAB  where  d_data_id ='J.0012.0017.S001'   and d_datetime > '2019-11-01 00:00:00'  and d_file_id like  '"+ss+"';");
		}

	}

}
