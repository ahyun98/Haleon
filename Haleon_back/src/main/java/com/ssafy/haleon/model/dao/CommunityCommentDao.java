package com.ssafy.haleon.model.dao;

import com.ssafy.haleon.model.dto.CommunityComment;

public interface CommunityCommentDao {
	void insertCommunityComment(CommunityComment CC);

	void deleteCommunityComment(String category, int num, int seq);
	void modifyCommunityComment(String category, int num, int seq, 
			CommunityComment communityComment);

}
