package Pojo;

public class EmpDetails {
	String eName;
	int eId;
	int phnNum;
	String email;
	String address;

	public EmpDetails() {
		// TODO Auto-generated constructor stub
	}

	public EmpDetails(String eName, int eId, int phnNum, String email, String address) {

		this.eName = eName;
		this.eId = eId;
		this.phnNum = phnNum;
		this.email = email;
		this.address = address;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public int getPhnNum() {
		return phnNum;
	}

	public void setPhnNum(int phnNum) {
		this.phnNum = phnNum;
	}

	public String getEmail() {
		return email;
	}
	

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
