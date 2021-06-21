package Reserve;

import java.io.IOException;
import java.util.ArrayList;

public interface Reserve {
	ArrayList<ReserveVO> checkReserveInfo(ReserveVO vo) throws IOException;
	public void reserveCamping(ReserveVO vo) throws IOException;
	public String viewReservation(ReserveVO vo);
	public void modReserveInfo(ReserveVO vo);
	public void cancelReservation(ReserveVO vo);
}
