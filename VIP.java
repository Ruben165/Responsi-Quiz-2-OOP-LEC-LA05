package package1;

public class VIP extends Customer {
    private String email, lounge;

	public VIP(Integer points, String name, String gender, String phoneNum, String status, String lC_ID, String email, String lounge) {
		super(points, name, gender, phoneNum, status, lC_ID);
		this.email = email;
		this.lounge = lounge;
	}
	
	@Override
	public int genPoints() {
		int point = (int) (Math.random() * (this.getName().length()) * 2) + 1; 
		return point;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLounge() {
		return lounge;
	}

	public void setLounge(String lounge) {
		this.lounge = lounge;
	}
}
