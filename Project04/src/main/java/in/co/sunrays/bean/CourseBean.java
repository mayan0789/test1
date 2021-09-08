package in.co.sunrays.bean;

public class CourseBean extends Basebean {
	
	private String Course_Name;
	private String Discription;
	private String Duration;
	

	public String getDuration() {
		return Duration;
	}

	public void setDuration(String duration) {
		Duration = duration;
	}

	public  CourseBean(){
		//Default constructor;
	}

	public String getCourse_Name() {
		return Course_Name;
	}

	public String getDiscription() {
		return Discription;
	}

	public void setCourse_Name(String course_Name) {
		Course_Name = course_Name;
	}

	public void setDiscription(String discription) {
		Discription = discription;
	}
	public String getkey() {
		return id+ "";
	}
	public String getvalue() {

		return Course_Name;
	}

}
