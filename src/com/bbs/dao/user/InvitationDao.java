package com.bbs.dao.user;

import java.text.ParseException;
import java.util.List;

import com.bbs.entity.Invitation;

public interface InvitationDao {

	List<Invitation> getInvitationList() throws ParseException;

	int saveInvitation(Invitation invitation);

	int delAll(String[] iids);

	int delById(String invitationId);

	Invitation findEdit(String invitationId);

	int update(Invitation invitation);

}
