package package1;

public abstract class Customer {
    private Integer points;
    private String name, gender, phoneNum, status, LC_ID;
    
	public Customer(Integer points, String name, String gender, String phoneNum, String status, String lC_ID) {
		super();
		this.points = points;
		this.name = name;
		this.gender = gender;
		this.phoneNum = phoneNum;
		this.status = status;
		this.LC_ID = lC_ID;
	}

	public abstract int genPoints();

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLC_ID() {
		return LC_ID;
	}

	public void setLC_ID(String lC_ID) {
		LC_ID = lC_ID;
	}
}
