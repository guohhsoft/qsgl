package czxy.qsgl.entity;

import java.util.Date;

public class FangKe {
private String id;
private String LFname;
private String Idcard;
private String time;
private String telephone;
private String reson;
private String BFname;
private String louhao;
private String sushehao;
private String time1;
public String getTime1() {
	return time1;
}
public void setTime1(String time1) {
	this.time1 = time1;
}
@Override
public String toString() {
	return "FangKe [id=" + id + ", LFname=" + LFname + ", Idcard=" + Idcard
			+ ", time=" + time + ", telephone=" + telephone + ", reson="
			+ reson + ", BFname=" + BFname + ", louhao=" + louhao
			+ ", sushehao=" + sushehao + ", time1=" + time1 + "]";
}
public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}
public String getLFname() {
	return LFname;
}
public void setLFname(String lFname) {
	LFname = lFname;
}
public String getIdcard() {
	return Idcard;
}
public void setIdcard(String idcard) {
	Idcard = idcard;
}

public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}
public String getReson() {
	return reson;
}
public void setReson(String reson) {
	this.reson = reson;
}
public String getBFname() {
	return BFname;
}
public void setBFname(String bFname) {
	BFname = bFname;
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

}
