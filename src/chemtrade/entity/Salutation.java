package chemtrade.entity;

public class Salutation {
	private int value;
	private String title;
	
	public Salutation(int value, String title) {
		this.value = value;
		this.title = title;
		// TODO Auto-generated constructor stub
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

}
