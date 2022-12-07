package package1;

public class Regular extends Customer {
    private int queue;
    
    public Regular(Integer points, String name, String gender, String phoneNum, String status, String lC_ID, int queue) {
		super(points, name, gender, phoneNum, status, lC_ID);
		this.queue = queue;
	}
    
    @Override
    public int genPoints() {
		int point = (int) (Math.random() * (this.getName().length())) + 1; 
		return point;
	}

	public int getQueue() {
		return queue;
	}

	public void setQueue(int queue) {
		this.queue = queue;
	}
}
