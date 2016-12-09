package entity;

import java.util.HashMap;

public class VipUser {

	private int uid;
	private String uname;
	private int uage;
	private String unumber;
	private String ugoods;
	
	public VipUser(){}

	public VipUser(int uid, String uname, int uage, String unumber,
			String ugoods) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.uage = uage;
		this.unumber = unumber;
		this.ugoods = ugoods;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public int getUage() {
		return uage;
	}

	public void setUage(int uage) {
		this.uage = uage;
	}

	public String getUnumber() {
		return unumber;
	}

	public void setUnumber(String unumber) {
		this.unumber = unumber;
	}

	public String getUgoods() {
		return ugoods;
	}

	public void setUgoods(String ugoods) {
		this.ugoods = ugoods;
	}

	@Override
	public String toString() {
		return "VipUser [uid=" + uid + ", uname=" + uname + ", uage=" + uage
				+ ", unumber=" + unumber + ", ugoods=" + ugoods + "]";
	}

	
	
}
