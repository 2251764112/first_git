package com.bbs.service;

import java.text.ParseException;
import java.util.List;

import com.bbs.entity.Invitation;
import com.bbs.entity.Plate;
import com.bbs.entity.invitationAns;

public interface InvitationService {

	List<Invitation> getInvitationList() throws ParseException;

	boolean saveInvitation(Invitation invitation);

	boolean delAll(String invitationIds);

	Invitation findEdit(String invitationId);

	boolean delById(String invitationId);

	boolean update(Invitation invitation);

	boolean addInvitationAns(invitationAns invitationans);

}
