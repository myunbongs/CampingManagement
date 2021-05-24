package Camping;

public class CampingVO {
	int campingNumber;
	String campingName;
	int campingMax;
	String campingAddress;
	int campingPrice;
	
	public CampingVO(){
		
	}
	
	public CampingVO(int campingNumber, String campingName, int campingMax, String campingAddress, int campingPrice) {
		this.campingNumber = campingNumber;
		this.campingName = campingName;
		this.campingMax = campingMax;
		this.campingAddress = campingAddress;
		this.campingPrice = campingPrice;
	}
}

