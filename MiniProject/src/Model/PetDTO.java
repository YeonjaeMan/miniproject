package Model;

public class PetDTO {

	private String name; // 펫 이름
	private String spec; // 펫 종류
	private int hp; // 펫 체력
	private int fullness; // 펫 포만감
	private int love; // 펫 애정도
	
	public PetDTO(String name, String spec, int hp, int fullness, int love) {
		this.name = name;
		this.spec = spec;
		this.hp = hp;
		this.fullness = fullness;
		this.love = love;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getFullness() {
		return fullness;
	}

	public void setFullness(int fullness) {
		this.fullness = fullness;
	}

	public int getLove() {
		return love;
	}

	public void setLove(int love) {
		this.love = love;
	}
	
	
	
}
