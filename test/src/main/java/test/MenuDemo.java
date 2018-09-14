package test;

public enum MenuDemo {
	USER_TYPE("student",1),USER_TYPE2("teacher",2);
	String name;
	int value;
	private MenuDemo(String name, int value) {
		this.name = name;
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
}
