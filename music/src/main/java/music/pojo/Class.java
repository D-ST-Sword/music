package music.pojo;

public class Class extends BaseEntity {
	
	private String classId;
	private String name;
	
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Class [classId=" + classId + ", name=" + name + "]";
	}
	
}
