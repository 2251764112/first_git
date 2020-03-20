package com.bbs.dao.user.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.bbs.commons.DataUtils;
import com.bbs.dao.user.PlateDao;
import com.bbs.entity.Plate;

public class PlateDaoImpl implements PlateDao{
	private ResultSet rs = null;
	
	@Override
	public int savePlate(Plate plate) {
		// 创建sql语句
				String sql = "insert into bbs_plate(plateTitle,plateMessage,isEnable) values (?,?,0)";
				Object[] params = {plate.getPlateTitle(),plate.getPlateMessage()};
				return DataUtils.executeUpdate(sql, params);
		
	}

	@Override
	public List<Plate> getPlateList() throws ParseException{
		List<Plate> lists=new ArrayList<Plate>();
		
		try {
			String sql= "select * from bbs_plate";
			rs = DataUtils.queryAll(sql, null);
			while(rs.next()) {
				Plate plate=new Plate();
				plate.setPlateId(rs.getInt("plateId"));
				plate.setPlateTitle(rs.getString("plateTitle"));
				plate.setPlateMessage(rs.getString("plateMessage"));
				plate.setIsEnable(rs.getInt("isEnable"));
				lists.add(plate);
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
	public Plate findEdit(int plateId) {
		Plate plate=new Plate();
		try {
			String sql = "select * from bbs_plate where plateId=?";
			Object[] params = {plateId};
			rs = DataUtils.queryAll(sql, params);
			if(rs.next()) {
				plate.setPlateId(rs.getInt("plateId"));
				plate.setPlateTitle(rs.getString("plateTitle"));
				plate.setPlateMessage(rs.getString("plateMessage"));
				plate.setIsEnable(rs.getInt("isEnable"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DataUtils.closeAll(null, null, rs);
		}
		return plate;
	}
	@Override
	public int delById(String plateId) {
		String sql = "delete from bbs_plate where plateId=?";
		Object[] params = {plateId};
		return DataUtils.executeUpdate(sql, params);
	}
	@Override
	public int update(Plate plate) {
		String sql = "update bbs_plate set plateTitle=?,plateMessage=? where plateId=?";
		Object[] params = {plate.getPlateTitle(),plate.getPlateMessage(),plate.getPlateId()};
		return DataUtils.executeUpdate(sql, params);
	}

	@Override
	public int delAll(String[] pids) {
		StringBuffer sql = new StringBuffer("delete from bbs_plate where plateId in(");
		// 根据参数数组的长度，拼接锁需要的?号个数
		for (int i = 0; i < pids.length; i++) {
			sql.append("?");
			if (i != pids.length-1) {
				sql.append(",");
			}
		}
		sql.append(")");
		// delete from bbs_plate where plateId in(test001,test002)
		return DataUtils.executeUpdate(sql.toString(), pids);
	}

	
	
}
