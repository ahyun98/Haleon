package com.ssafy.haleon.model.dto;

public class CommunityComment {
	private String category;
	private int num;
	private String content;
	private String username;
	private String id;
	private String pw;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int no) {
		this.num = no;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	@Override
	public String toString() {
		return "RoutineComment [category=" + category + ", num=" + num + ", content=" + content + ", username=" + username
				+ ", id=" + id + ", pw=" + pw + "]";
	}
	
}
