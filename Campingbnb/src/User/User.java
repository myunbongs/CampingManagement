package User;

import java.io.IOException;

public interface User {
	public void registerUser(UserVO vo) throws IOException; //ȸ�� ��� �޼���
	public String viewUser(UserVO vo) throws IOException; //ȸ�� ���� ��ȸ �޼���
	public void modifyUser(UserVO vo);
	public void deleteUser(UserVO vo);

}
