package Reserve;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import base.Base;
// import ex4.common.DataUtil;

public class ReserveImpl extends Base implements Reserve{
	String reserveData;
	
	@Override
	public void reserveCamping(ReserveVO vo) throws IOException {
		File file=new File("reserveData.txt");
		
		PrintWriter out=new PrintWriter(new FileWriter(file,true));
		
		reserveData = vo.resNumber +","+
					vo.userId + "," + 
					vo.campingNumber + "," + 
					vo.resDate+","+
					vo.beginDate+","+
					vo.endDate + "," +
					vo.resPrice + "\n";
			System.out.println("캠핑장 예약 시간:"+showTime());
			out.println(reserveData);
			out.close();
			
			System.out.println("예약 정보를 파일 저장했습니다.");
	}
	
	
	@Override
	public ArrayList<ReserveVO> checkReserveInfo(ReserveVO vo) throws IOException {
		ArrayList<ReserveVO> reserveList=new ArrayList<ReserveVO>();
		String reserveInfo=null;
		String reserveData[]=null;
		
		File file =new File("reserveData.txt");
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);

		while((reserveInfo=br.readLine())!=null){
			reserveData = reserveInfo.split(",");
			ReserveVO reserveVo = new ReserveVO();
			
			reserveVo.resNumber = Integer.parseInt(reserveData[0]);
			reserveVo.userId = reserveData[1];
			reserveVo.campingNumber = reserveData[2];
			reserveVo.resDate = reserveData[3];
			reserveVo.beginDate = reserveData[4];
			reserveVo.endDate = reserveData[5];
			reserveVo.resPrice = reserveData[6];
			
			reserveList.add(reserveVo);
		}
		fr.close();
		br.close();
		return reserveList;
	}
	
	
	
	@Override
	public String viewReservation(ReserveVO vo)
	{
		return null;
	}
	
	
	@Override
	public void modReserveInfo(ReserveVO vo)
	{
		
	}
	
	
	@Override
	public void cancelReservation(ReserveVO vo)
	{
		
	}
}