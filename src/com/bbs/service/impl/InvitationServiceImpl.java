package com.bbs.service.impl;

import java.text.ParseException;
import java.util.List;

import com.bbs.dao.user.InvitationDao;
import com.bbs.dao.user.impl.InvitationDaoImpl;
import com.bbs.entity.Invitation;
import com.bbs.service.InvitationService;

public class InvitationServiceImpl implements InvitationService{
	private InvitationDao it=new InvitationDaoImpl();
	@Override
	public List<Invitation> getInvitationList() throws ParseException{
		// TODO Auto-generated method stub
		return it.getInvitationList();
	}
	@Override
	public boolean saveInvitation(Invitation invitation) {
		int result=it.saveInvitation(invitation);
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public boolean delAll(String invitationIds) {
		// 将字符串中的所有引号去掉，并截取[]中的数据
		invitationIds = invitationIds.substring(1, invitationIds.lastIndexOf("]")).replaceAll("\"", "");
		// 将字符窜进行拆分为数组
		String[] iids = invitationIds.split(",");
		int result=it.delAll(iids);
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public Invitation findEdit(String invitationId) {
		return it.findEdit(invitationId);
	}
	@Override
	public boolean delById(String invitationId) {
		int result=it.delById(invitationId);
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public boolean update(Invitation invitation) {
		int result=it.update(invitation);
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}

}
