package diploma.Model;

import java.io.Serializable;

public class User implements Serializable {
	private int userid;
	private String email;
	private String username;
	private String password;
	private String usertype;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	// public User() {
	// super();
	// }

	// public User(int userid, String email, String username, String password, int
	// age, Address address) {
	// super();
	// this.userid = userid;
	// this.email = email;
	// this.username = username;
	// this.password = password;
	// this.age = age;
	// this.address = address;
	// }

	private int age;
	// private Address address;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// public Address getAddress() {
	// return address;
	// }

	// public void setAddress(Address address) {
	// this.address = address;
	// }

}