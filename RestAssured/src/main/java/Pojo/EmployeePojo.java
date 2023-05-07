package Pojo;

public class EmployeePojo {
	String eName;
	String[]mail;
	int[]phnNum;
	int empId;
	SpouseDetails sd;
	public EmployeePojo() {
		// TODO Auto-generated constructor stub
	}
	public EmployeePojo(String eName, String[] mail, int[] phnNum, int empId, SpouseDetails sd) {
		this.eName = eName;
		this.mail = mail;
		this.phnNum = phnNum;
		this.empId = empId;
		this.sd = sd;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String[] getMail() {
		return mail;
	}
	public void setMail(String[] mail) {
		this.mail = mail;
	}
	public int[] getPhnNum() {
		return phnNum;
	}
	public void setPhnNum(int[] phnNum) {
		this.phnNum = phnNum;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public SpouseDetails getSd() {
		return sd;
	}
	public void setSd(SpouseDetails sd) {
		this.sd = sd;
	}
	
	
	
	
	

}
