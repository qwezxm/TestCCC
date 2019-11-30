package rabbit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.alibaba.fastjson.JSON;

public class DoSql {
    
	public static  int  add(XIAOXI xiaoxi) throws ParseException{
		 Connection connection =  ConnectionFacy.getDataSource();
		 PreparedStatement stmt = null;
         //
		 String sql = "insert into XBRY1.OTHE_MODI_MOPR_AOI_TAB(D_RECORD_ID,D_DATA_ID, "
			 +	" D_IYMDHM,D_RYMDHM,D_UPDATE_TIME,D_DATETIME,PLANE_ID,V05001,V06001,V04001, "
			 +	" V04002,V04003,V04004,V04005,V04006,COMM_TYPE,ELEMENTS_VALUES,V59001,V59002,V59003,V59004) "
			 +	" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		 try {
			String a1 =  xiaoxi.getDate();
			String a2 = xiaoxi.getTime();
			String a = a1 + a2;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			//传入日期
			Date dd = sdf.parse(a);
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			String d22 = sdf2.format(dd);
			//当前日期
			Date d2 = new Date();
			String date = sdf2.format(d2);
			
			Calendar cc = Calendar.getInstance();
			cc.setTime(dd);
			
			stmt = connection.prepareStatement(sql);
			stmt.setObject(1,"");
			stmt.setObject(2,"F.0000.0000.0000");
			stmt.setObject(3,date);
			stmt.setObject(4,d22);
			stmt.setObject(5,d22);
			stmt.setObject(6,d22);
			stmt.setObject(7,xiaoxi.getFjbh());
			stmt.setObject(8,xiaoxi.getLati());
			stmt.setObject(9,xiaoxi.getLongs());
			stmt.setObject(10,cc.get(Calendar.YEAR));
			stmt.setObject(11,cc.get(Calendar.MONTH)+1);
			stmt.setObject(12,cc.get(Calendar.DAY_OF_MONTH));
			stmt.setObject(13,cc.get(Calendar.HOUR_OF_DAY));
			stmt.setObject(14,cc.get(Calendar.MINUTE));
			stmt.setObject(15,cc.get(Calendar.SECOND));
			stmt.setObject(16,"");
			stmt.setObject(17,xiaoxi.getContent());
			stmt.setObject(18,"");
			stmt.setObject(19,"");
			stmt.setObject(20,"");
			stmt.setObject(21,"");
			int i = stmt.executeUpdate();
			if(i==1){
				System.out.println("入库成功");
			}else{
				System.out.println("入库失败");
			}
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(stmt!=null) 	stmt.close();
				if(connection!=null) 	connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
		 
	 }
	 public static void main(String[] args) throws ParseException {
         String json ="{\"xh\":\"00007\",\"fjbh\":\"212848\",\"date\":\"20191220\",\"time\":\"154055\",\"longs\":\"116.30112\",\"lati\":\"39.97896\",\"height\":\"75\",\"content\":\"000,162,0.000,000\"} ";
         XIAOXI xiaoxi = JSON.parseObject(json,XIAOXI.class);
         System.out.println(xiaoxi);
         int i = DoSql.add(xiaoxi);
         System.out.println(i);
	}
	
}
