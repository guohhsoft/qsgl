package czxy.qsgl.entity;

public class Department {
	private String id;
	private String department;
	@Override
	public String toString() {
		return "department [id=" + id + ", department=" + department + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
}
