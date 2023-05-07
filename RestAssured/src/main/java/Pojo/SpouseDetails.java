package Pojo;

public class SpouseDetails {
	String spouseName;
	String[] mail;
	int[] phnNum;

	public SpouseDetails() {
		// TODO Auto-generated constructor stub
	}

	public SpouseDetails(String spouseName, String[] mail, int[] phnNum) {
		this.spouseName = spouseName;
		this.mail = mail;
		this.phnNum = phnNum;
	}

	public String getSpouseName() {
		return spouseName;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
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

}
