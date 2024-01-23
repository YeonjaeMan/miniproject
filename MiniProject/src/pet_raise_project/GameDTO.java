package pet_raise_project;

public class GameDTO {

	private String petName; // 펫 이름
	private String petKind; // 펫 종류
	private int petHp; // 펫 체력
	private int petSatiety; // 펫 포만감
	private int petAffection; // 펫 애정도
	private String userId; // 사용자 아이디
	private String userPw; // 사용자 비밀번호

	public GameDTO(String petName, String petKind, int petHp, int petSatiety, int petAffection, String userId,
			String userPw) {
		this.petName = petName;
		this.petKind = petKind;
		this.petHp = petHp;
		this.petSatiety = petSatiety;
		this.petAffection = petAffection;
		this.userId = userId;
		this.userPw = userPw;
	}
	
	public GameDTO(String userId, String userPw) {
		super();
		this.userId = userId;
		this.userPw = userPw;
	}
	
	public GameDTO(String petName, String userId, String userPw) {
		super();
		this.petName = petName;
		this.userId = userId;
		this.userPw = userPw;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getPetKind() {
		return petKind;
	}

	public void setPetKind(String petKind) {
		this.petKind = petKind;
	}

	public int getPetHp() {
		return petHp;
	}

	public void setPetHp(int petHp) {
		this.petHp = petHp;
	}

	public int getPetSatiety() {
		return petSatiety;
	}

	public void setPetSatiety(int petSatiety) {
		this.petSatiety = petSatiety;
	}

	public int getPetAffection() {
		return petAffection;
	}

	public void setPetAffection(int pet_affection) {
		this.petAffection = petAffection;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
}
