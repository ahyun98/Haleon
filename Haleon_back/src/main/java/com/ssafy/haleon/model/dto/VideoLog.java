package com.ssafy.haleon.model.dto;

public class VideoLog {
	private int seq;
	private String id;
	private String videoId;
	private int viewCnt;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setUserName(String id) {
		this.id = id;
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
		return "videoLog [seq=" + seq + ", id=" + id + ", videoId=" + videoId + ", viewCnt=" + viewCnt
				+ "]";
	}
	
	
}
