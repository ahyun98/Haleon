package com.ssafy.haleon.model.dao;

import com.ssafy.haleon.model.dto.RoutineComment;

public interface RoutineCommentDao {
	void insertCommunityComment(RoutineComment RC);

	void deleteCommunityComment(int num, int seq);
	void modifyCommunityComment(int num, int seq, 
			RoutineComment routineComment);
}
