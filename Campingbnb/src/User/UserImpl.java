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
		 * if(id==null || id.equals("")){ throw new UserException("아이디는 필수 입력 정보입니다.");
		 * }else{
		 */	
			userData =vo.id+","+
					vo.password+","+
					vo.name+","+
					vo.phoneNum + "," +
					vo.email + "," +
					vo.role ;
			System.out.println("회원 등록 시간:"+showTime());
			out.println(userData);
			out.close();
			
			System.out.println("유저 정보를 파일 저장했습니다.");
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

	
	
	//기존 회원 정보를 수정하는 메서드
	public void modifyUser(UserVO vo) {
		userData = vo.id+","+
				vo.password+","+
				vo.name+","+
				vo.phoneNum + "," +
				vo.email + "," +
				vo.role ;
		
		System.out.println("회원 정보 수정시간:"+showTime());
		System.out.println("회원 정보를 수정합니다.");
	}

	
	public void deleteUser(UserVO vo) {
		userData = vo.id+","+
				vo.password+","+
				vo.name+","+
				vo.phoneNum + "," +
				vo.email + "," +
				vo.role ;
				
		System.out.println("회원 정보 삭제시간:"+showTime());
		System.out.println("회원 정보를 삭제합니다.");
	}

}
