package com.bbs.dao.user.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.bbs.commons.DataUtils;
import com.bbs.dao.user.InvitationDao;
import com.bbs.entity.Invitation;

public class InvitationDaoImpl implements InvitationDao{
	private ResultSet rs = null;

	@Override
	public List<Invitation> getInvitationList() throws ParseException {
		List<Invitation> lists=new ArrayList<Invitation>();
		try {
			String sql= "SELECT i.*,p.plateTitle,c.category FROM bbs_invitation i\r\n" + 
					"INNER JOIN bbs_plate p ON(i.`plateId`=p.`plateId`)\r\n" + 
					"INNER JOIN bbs_category c ON(i.`categoryId`=c.`categoryId`)";
			rs = DataUtils.queryAll(sql, null);
			while(rs.next()) {
				Invitation invitation=new Invitation();
				invitation.setInvitationId(rs.getString("invitationId"));
				invitation.setInvitationMessage(rs.getString("invitationMessage"));
				invitation.setUserId(rs.getString("userId"));
				invitation.setPlateTitle(rs.getString("plateTitle"));
				invitation.setCategoryId(rs.getInt("categoryId"));
				invitation.setIsPass(rs.getInt("isPass"));
				invitation.setIsEnable(rs.getInt("isEnable"));
				invitation.setIsCream(rs.getInt("isCream"));
				lists.add(invitation);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DataUtils.closeAll(null, null, rs);
		}
		return lists;
	}

	@Override
	public int saveInvitation(Invitation invitation) {
		// 创建sql语句
		String sql = "insert into bbs_invitation(invitationId,invitationMessage,userId,plateId,categoryId) values (?,?,?,?,?)";
		Object[] params = {invitation.getInvitationId(),invitation.getInvitationMessage(),invitation.getUserId(),invitation.getPlateTitle(),invitation.getCategoryId()};
		return DataUtils.executeUpdate(sql, params);
	}

	@Override
	public int delAll(String[] iids) {
		StringBuffer sql = new StringBuffer("delete from bbs_invitation where invitationId in(");
		// 根据参数数组的长度，拼接锁需要的?号个数
		for (int i = 0; i < iids.length; i++) {
			sql.append("?");
			if (i != iids.length-1) {
				sql.append(",");
			}
		}
		sql.append(")");
		// delete from bbs_plate where plateId in(test001,test002)
		return DataUtils.executeUpdate(sql.toString(), iids);
	}

	@Override
	public int delById(String invitationId) {
		String sql = "delete from bbs_invitation where invitationId=?";
		Object[] params = {invitationId};
		return DataUtils.executeUpdate(sql, params);
	}

	@Override
	public Invitation findEdit(String invitationId) {
		Invitation invitation=new Invitation();
		try {
			String sql = "select * from bbs_invitation where invitationId=?";
			Object[] params = {invitationId};
			rs = DataUtils.queryAll(sql, params);
			if(rs.next()) {
				invitation.setInvitationId(rs.getString("invitationId"));
				invitation.setInvitationMessage(rs.getString("invitationMessage"));
				invitation.setUserId(rs.getString("userId"));
				invitation.setPlateTitle(rs.getString("plateId"));
				invitation.setCategoryId(rs.getInt("categoryId"));
				invitation.setIsPass(rs.getInt("isPass"));
				invitation.setIsEnable(rs.getInt("isEnable"));
				invitation.setIsCream(rs.getInt("isCream"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DataUtils.closeAll(null, null, rs);
		}
		return invitation;
	}

	@Override
	public int update(Invitation invitation) {
		String sql = "update bbs_invitation set invitationMessage=?,plateId=?,categoryId=? where invitationId=?";
		Object[] params = {invitation.getInvitationMessage(),Integer.parseInt(invitation.getPlateTitle()),invitation.getCategoryId(),invitation.getInvitationId()};
		return DataUtils.executeUpdate(sql, params);
	}

	

}
