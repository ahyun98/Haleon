package com.ssafy.haleon.model.service;

import java.util.HashMap;
import java.util.List;

import com.ssafy.haleon.model.dto.Profile;

public interface ProfileService {
	void writeProfile(Profile profile);
	void modifyProfile(Profile profile);
	void deleteProfile(String id);
	Profile selectOne(String id);
	
	//필요할까..?
	List<Profile> selectList(HashMap<String, String> params);
}
