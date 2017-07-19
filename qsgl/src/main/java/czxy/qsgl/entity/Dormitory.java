package czxy.qsgl.entity;

public class Dormitory {
	private String id;
	private String louhao;
	private String sushehao;
	private String department;
	private String depict;
	private int max;
	private int now;
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getNow() {
		return now;
	}
	public void setNow(int now) {
		this.now = now;
	}
	@Override
	public String toString() {
		return "Dormitory [id=" + id + ", louhao=" + louhao + ", sushehao="
				+ sushehao + ", department=" + department + ", depict="
				+ depict + ", max=" + max + ", now=" + now + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDepict() {
		return depict;
	}
	public void setDepict(String depict) {
		this.depict = depict;
	}
	
}
