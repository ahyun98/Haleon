package com.ssafy.haleon.model.service;

import com.ssafy.haleon.model.dto.Profile;

public interface ProfileService {
	void writeProfile(Profile profile);
	void modifyProfile(Profile profile);
	void deleteProfile(String id);
	Profile selectOne(String id);

}
