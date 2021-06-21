package User;

import java.io.IOException;

public interface User {
	public void registerUser(UserVO vo) throws IOException; //회원 등록 메서드
	public String viewUser(UserVO vo) throws IOException; //회원 정보 조회 메서드
	public void modifyUser(UserVO vo);
	public void deleteUser(UserVO vo);

}
