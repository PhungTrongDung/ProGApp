package model;

import java.util.Objects;

import javax.print.attribute.standard.JobOriginatingUserName;

public class user {
	private String name;
	private String email;
	private String sdt;
	private String useName;
	private String pass;
	
	
	
	public user(String name, String email, String sdt, String useName, String pass) {
		super();
		this.name = name;
		this.email = email;
		this.sdt = sdt;
		this.useName = useName;
		this.pass = pass;
	}
	
//	public user(String useName, String pass) {
//		this.useName = useName;
//		this.pass = pass;
//	}
	
	
	
	public String getUseName() {
		return useName;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public void setUseName(String useName) {
		this.useName = useName;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	@Override
	public String toString() {
		return this.name + ";" + this.email + ";" + this.sdt + ";" + this.useName + ";" + this.pass;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		user other = (user) obj;
		return Objects.equals(pass, other.pass)
				&& Objects.equals(useName, other.useName);
	}
	
	
	
}
