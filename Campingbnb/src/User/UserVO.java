package User;

public class UserVO {
	String id;
	String password;
	String name;
	String phoneNum;
	String email;
	String role;
	
	public UserVO() {
		
	}
	
	public UserVO(String id, String password, String name, String phoneNum, String email, String role) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.phoneNum = phoneNum;
		this.email = email;
		this.role = role; // 일단 임시로 string 데베로 구현시 숫자가 좋을 듯 
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email; 
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getRole() {
		return role; 
	}
	
	public void setRole(String role) {
		this.role = role;
	}
}
