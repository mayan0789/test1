package in.co.sunrays.bean;

public class RoleBean extends Basebean {
	private static final int ADMIN = 0;
	private static int KIOSK;
	private static int STUDENT;
	private static int COLLEGE_SCHOOL;
	
	private String name ;
	private String description;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getKey() {
		return null;
		
	}
	public String getValue() {
		return null;
		
	}
	}
