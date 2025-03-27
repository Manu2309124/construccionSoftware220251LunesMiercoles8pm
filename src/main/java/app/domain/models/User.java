package app.domain.models;

public class User {
	private long UserId;
	private String personId;
	private String password;
	private String userName;
	private String role;
	public User(long UserId, String personId, String password, String userName, String role) {
		super();
		this.UserId = UserId;
		this.personId = personId;
		this.password = password;
		this.userName = userName;
		this.role = role;
	}
	public long getUserId() {
		return UserId;
	}
	public void setUserId(long UserId) {
		this.UserId = UserId;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
