package com.ssafy.haleon.model.dto;

public class VideoLog {
	private int seq;
	private String userName;
	private String videoId;
	private int viewCnt;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getVideoId() {
		return videoId;
	}
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	@Override
	public String toString() {
		return "videoLog [seq=" + seq + ", userName=" + userName + ", videoId=" + videoId + ", viewCnt=" + viewCnt
				+ "]";
	}
	
	
}
