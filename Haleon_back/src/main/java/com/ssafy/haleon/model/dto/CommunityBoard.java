package com.ssafy.haleon.model.dto;

public class CommunityBoard {
	private int num;
	private String category;
	private String writer;
	private String title;
	private String content;
	private int viewCnt;
	private String regDate;
	private String fileName;
	private String fileUri;
	
	public CommunityBoard() {
		super();
	}
	public CommunityBoard(int num, String category, String writer, String title, String content, int viewCnt,
			String regDate) {
		super();
		this.num = num;
		this.category = category;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.viewCnt = viewCnt;
		this.regDate = regDate;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileUri() {
		return fileUri;
	}
	public void setFileUri(String fileUri) {
		this.fileUri = fileUri;
	}
	
	@Override
	public String toString() {
		return "CommunityBoard [num=" + num + ", category=" + category + ", writer=" + writer + ", title=" + title
				+ ", content=" + content + ", viewCnt=" + viewCnt + ", regDate=" + regDate + ", fileName=" + fileName
				+ ", fileUri=" + fileUri + "]";
	}	
	
}
