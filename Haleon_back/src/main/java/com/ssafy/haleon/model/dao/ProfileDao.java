package com.ssafy.haleon.model.dao;

import java.util.HashMap;
import java.util.List;

import com.ssafy.haleon.model.dto.Profile;

public interface ProfileDao {
	void updateProfile(Profile profile);
	void insertProfile(Profile profile);
	void deleteProfile(String id);
	Profile selectOne(String id);
}
 