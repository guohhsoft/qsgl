package czxy.qsgl.entity;

public class Student {
	private String studentId;    //学号 学号是唯一的  作为主键
	private String name;         //名字
	private String sex;				// 性别
	private String department;   //系别
	private String louhao;		 // 楼号
	private String sushehao;	 // 宿舍号
	private String addr;        //家庭住址
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getLouhao() {
		return louhao;
	}
	public void setLouhao(String louhao) {
		this.louhao = louhao;
	}
	public String getSushehao() {
		return sushehao;
	}
	public void setSushehao(String sushehao) {
		this.sushehao = sushehao;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", department=" + department + ", louhao="
				+ louhao + ", sushehao=" + sushehao + ", addr=" + addr + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((studentId == null) ? 0 : studentId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (studentId == null) {
			if (other.studentId != null)
				return false;
		} else if (!studentId.equals(other.studentId))
			return false;
		return true;
	}
	public Student() {
		
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

}
