package Model;

public class UserDTO {

	private String id;
	private String pw;
	private int money;
	
	public UserDTO(String id, String pw, int money) {
		this.id = id;
		this.pw = pw;
		this.money = money;
	}
	
	public UserDTO(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	
	
}
