package Camping;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface Camping {
	ArrayList<CampingVO> checkCampingInfo(CampingVO vo) throws IOException;
	ArrayList<CampingVO> checkCampingsInfo(CampingVO vo) throws FileNotFoundException;
	public void uploadCampingInfo(CampingVO vo) throws IOException;
	public void viewCampingInfo(CampingVO vo);  
	public void modifyCampingInfo(CampingVO vo);
	public void deleteCampingInfo(CampingVO vo);
}
