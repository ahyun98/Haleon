package com.ssafy.haleon.model.service;

import java.util.HashMap;
import java.util.List;

import com.ssafy.haleon.model.dto.Profile;
import com.ssafy.haleon.model.dto.RoutineBoard;

public interface ProfileService {
	void writeProfile(Profile profile);
	void modifyProfile(Profile profile);
	void deleteProfile(String id);
	Profile selectOne(String id);
	List<Profile> getProfileList(HashMap<String, String> params);

}
