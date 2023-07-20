package com.ssafy.fit.model.dto;

public class User {
	private String id;
	private String password;
	private String name;
	private String nickName;
	private String email;
	private int user_rank;
	private String address;
	private String img;
	
	public User() {
		
	}

	public User(String id, String password, String name, String nickName, String email, int user_rank, String address,
			String img) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.nickName = nickName;
		this.email = email;
		this.user_rank = user_rank;
		this.address = address;
		this.img = img;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUser_rank() {
		return user_rank;
	}

	public void setUser_rank(int user_rank) {
		this.user_rank = user_rank;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", name=" + name + ", nickName=" + nickName + ", email="
				+ email + ", user_rank=" + user_rank + ", address=" + address + ", img=" + img + "]";
	}
	
	

}
