package User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import base.Base;

public class UserImpl extends Base implements User {
	String userData;
	
	public void registerUser(UserVO vo) throws IOException {
		File file = new File("userData.txt");
		PrintWriter out = new PrintWriter(new FileWriter(file,true));
		/*
		 * if(id==null || id.equals("")){ throw new UserException("���̵�� �ʼ� �Է� �����Դϴ�.");
		 * }else{
		 */	
			userData =vo.id+","+
					vo.password+","+
					vo.name+","+
					vo.phoneNum + "," +
					vo.email + "," +
					vo.role ;
			System.out.println("ȸ�� ��� �ð�:"+showTime());
			out.println(userData);
			out.close();
			
			System.out.println("���� ������ ���� �����߽��ϴ�.");
		//}

	}
	
	public String viewUser(UserVO vo) throws IOException{
		File file=new File("userData.txt");
		BufferedReader in = new BufferedReader(new FileReader(file));
		String userData = "";
		String data=in.readLine();
		while(data.contains(vo.id)){
			userData += data+"\n";
			data = in.readLine();
		}
		return userData;
	}

	
	
	//���� ȸ�� ������ �����ϴ� �޼���
	public void modifyUser(UserVO vo) {
		userData = vo.id+","+
				vo.password+","+
				vo.name+","+
				vo.phoneNum + "," +
				vo.email + "," +
				vo.role ;
		
		System.out.println("ȸ�� ���� �����ð�:"+showTime());
		System.out.println("ȸ�� ������ �����մϴ�.");
	}

	
	public void deleteUser(UserVO vo) {
		userData = vo.id+","+
				vo.password+","+
				vo.name+","+
				vo.phoneNum + "," +
				vo.email + "," +
				vo.role ;
				
		System.out.println("ȸ�� ���� �����ð�:"+showTime());
		System.out.println("ȸ�� ������ �����մϴ�.");
	}

}
