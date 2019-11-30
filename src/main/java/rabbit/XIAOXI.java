package rabbit;

public class XIAOXI {
	private String fjbh;
	private String date;
	private String time;
	private String longs;
	private String lati;
	private String height;
	private String content;
	public XIAOXI() {
		super();
		// TODO Auto-generated constructor stub
	}
	public XIAOXI(String fjbh, String date, String time, String longs, String lati, String height, String content) {
		super();
		this.fjbh = fjbh;
		this.date = date;
		this.time = time;
		this.longs = longs;
		this.lati = lati;
		this.height = height;
		this.content = content;
	}
	public String getFjbh() {
		return fjbh;
	}
	public void setFjbh(String fjbh) {
		this.fjbh = fjbh;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getLongs() {
		return longs;
	}
	public void setLongs(String longs) {
		this.longs = longs;
	}
	public String getLati() {
		return lati;
	}
	public void setLati(String lati) {
		this.lati = lati;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "XIAOXI [fjbh=" + fjbh + ", date=" + date + ", time=" + time + ", longs=" + longs + ", lati=" + lati
				+ ", height=" + height + ", content=" + content + "]";
	}
	
}
