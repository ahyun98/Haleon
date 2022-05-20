package com.ssafy.haleon.model.dto;

import lombok.Data;

@Data
public class RoutineBoard {
	private int num;
	private String writer;
	private String title;
	private String content;
	private int viewCnt;
	private String regDate;
	private String fileName;
	private String fileUri;
	
}
