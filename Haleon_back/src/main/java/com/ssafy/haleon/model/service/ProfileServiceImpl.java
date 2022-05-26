package com.ssafy.haleon.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.haleon.exception.UserNameDuplicateException;
import com.ssafy.haleon.model.dao.ProfileDao;
import com.ssafy.haleon.model.dto.Profile;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileDao profileDao;
	
	@Override
	public void writeProfile(Profile profile) {
		//중복 체크
		if(profileDao.selectOne(profile.getId()) == null)
			profileDao.insertProfile(profile);
		else
			new UserNameDuplicateException();
	}

	@Override
	public void modifyProfile(Profile profile) {
		Profile originProfile = profileDao.selectOne(profile.getId());
		originProfile.setId(profile.getId());
		originProfile.setBmi(profile.getBmi());
		originProfile.setHeight(profile.getHeight());
		originProfile.setPeriod(profile.getPeriod());
		originProfile.setWeight(profile.getWeight());
		originProfile.setFatRate(profile.getFatRate());
		originProfile.setMuscleRate(profile.getMuscleRate());
		profileDao.updateProfile(originProfile);
	}

	@Override
	public void deleteProfile(String id) {
		profileDao.deleteProfile(id);
	}

	@Override
	public Profile selectOne(String id) {
		return profileDao.selectOne(id);
	}

	@Override
	public List<Profile> selectList() {
		return profileDao.selectList();
	}

	@Override
	public List<Profile> selectListPeriod() {
		return profileDao.selectListPeriod();
	}

	@Override
	public List<Profile> selectListMuscle() {
		return profileDao.selectListMuscle();
	}


}
