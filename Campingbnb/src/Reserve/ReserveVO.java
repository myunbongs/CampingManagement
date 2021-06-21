package Reserve;

public class ReserveVO {
	int resNumber;
	String userId;
	String campingNumber;
	String resDate;
	String beginDate;
	String endDate;
	String resPrice;

	public ReserveVO()
	{
		
	}
	
	public ReserveVO(int resNumber, String userId, String campingNumber, String resDate, String beginDate, String endDate, String resPrice)
	{
		this.resNumber = resNumber;
		this.userId = userId;
		this.campingNumber = campingNumber; 
		this.resDate = resDate;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.resPrice = resPrice;
	}
	
	public int getResNumber() {
		return resNumber; 
	}
	
	public void setResNumber(int resNumber) {
		this.resNumber = resNumber;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getCampingNumber() {
		return campingNumber;
	}
	
	public void setCampingNumber(String campingNumber) {
		this.campingNumber = campingNumber;
	}
	
	public String getResDate() {
		return resDate;
	}
	
	public void setResDate(String resDate) {
		this.resDate = resDate;
	}
	
	
	public String getBeginDate() {
		return beginDate;
	}
	
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	
	
	public String getEndDate() {
		return endDate;
	}
	
	public void setEndDate(String endDate) {
		this.beginDate = endDate;
	}
	
	public String getResPrice() {
		return resPrice;
	}
	
	public void setrResPrice(String resPrice) {
		this.resPrice = resPrice;
	}
	
	
}
