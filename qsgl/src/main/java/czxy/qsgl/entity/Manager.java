package czxy.qsgl.entity;

public class Manager {
	private String id;
	private String name;
	private String password;
	private String job;
	private String telephone;
	private int quanxian;
	private String sushehao;
	public String getSushehao() {
		return sushehao;
	}
	public void setSushehao(String sushehao) {
		this.sushehao = sushehao;
	}
	private String louhao;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public int getQuanxian() {
		return quanxian;
	}
	public void setQuanxian(int quanxian) {
		this.quanxian = quanxian;
	}
	public String getLouhao() {
		return louhao;
	}
	public void setLouhao(String louhao) {
		this.louhao = louhao;
	}
	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", password="
				+ password + ", job=" + job + ", telephone=" + telephone
				+ ", quanxian=" + quanxian + ", sushehao=" + sushehao
				+ ", louhao=" + louhao + "]";
	}

}
