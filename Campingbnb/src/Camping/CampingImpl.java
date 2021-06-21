package Camping;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import base.Base;
// import ex4.common.DataUtil;

public class CampingImpl extends Base implements Camping{
	String campingData;
	
	@Override
	public void uploadCampingInfo(CampingVO vo) throws IOException {
		File file=new File("campingData.txt");
		
		PrintWriter out=new PrintWriter(new FileWriter(file,true));
		
		campingData = vo.campingNumber +","+
					vo.hostId + "," + 
					vo.campingName+","+
					vo.campingMax+","+
					vo.campingAddress + "," +
					vo.campingPrice;
			System.out.println("캠핑장 등록 시간:"+showTime());
			out.println(campingData);
			out.close();
			
			System.out.println("캠핑장 정보를 파일 저장했습니다.");
		
	}
	

	@Override
	public ArrayList<CampingVO> checkCampingInfo(CampingVO vo) throws IOException {
		ArrayList<CampingVO> campingList=new ArrayList<CampingVO>();
		String campingInfo=null;
		String campingData[]=null;
		
		File file =new File("campingData.txt");
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);

		while((campingInfo=br.readLine())!=null){
			campingData = campingInfo.split(",");
			CampingVO campingVo = new CampingVO();
			campingVo.campingNumber = Integer.parseInt(campingData[0]);
			campingVo.hostId = campingData[1];
			campingVo.campingName = campingData[2];
			campingVo.campingMax = Integer.parseInt(campingData[3]);
			campingVo.campingAddress = campingData[4];
			campingVo.campingPrice = Integer.parseInt(campingData[5]);
			
			campingList.add(campingVo);
		}
		fr.close();
		br.close();
		return campingList;
	}

	

	@Override
	public void viewCampingInfo(CampingVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyCampingInfo(CampingVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCampingInfo(CampingVO vo) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public ArrayList<CampingVO> checkCampingsInfo(CampingVO vo) throws FileNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
