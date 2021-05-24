package base;

import java.util.Calendar;

public class Base{
	
	//하위 클래스에서 조회된 정보를 출력하는 메서드
	public void displayData(String data){
		System.out.println("조회된 데이터>>"+data+"입니다.");
	}
	
	//메서드 호출 시 호출된 시각 정보를 출력하는 메서드
	public String showTime(){
		String date=null;
		String time=null;
		
		Calendar cal=Calendar.getInstance();
		
		int hour=cal.get(Calendar.HOUR);
		int min=cal.get(Calendar.MINUTE);
		int sec=cal.get(Calendar.SECOND);
		
		int year=cal.get(Calendar.YEAR);
		int month=cal.get(Calendar.MONTH)+1;
		int day=cal.get(Calendar.DATE);
		
		date=year+"-"+month+"-"+day;
		time=hour+":"+min+":"+sec;
		return date+" "+time;
		
	}

}
