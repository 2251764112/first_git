package com.bbs.service.impl;

import java.text.ParseException;
import java.util.List;

import com.bbs.dao.user.PlateDao;
import com.bbs.dao.user.impl.PlateDaoImpl;
import com.bbs.entity.Plate;
import com.bbs.service.PlateService;

public class PlateServiceImpl implements PlateService{
	private PlateDao pd=new PlateDaoImpl();
	@Override
	public boolean savePlate(Plate plate) {
		int result=pd.savePlate(plate);
		if(result>0) {
			return true;
		}else {
			return false;
		}
		
	}
	@Override
	public List<Plate> getPlateList() throws ParseException{
		// TODO Auto-generated method stub
		return pd.getPlateList();
	}
	
	
	@Override
	public Plate findEdit(int plateId) {
		
		return pd.findEdit(plateId);
	}
	@Override
	public boolean delById(String plateId) {
		int result=pd.delById(plateId);
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public boolean update(Plate plate) {
		int result=pd.update(plate);
		if(result>0) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public boolean delAll(String plateIds) {
		// 将字符串中的所有引号去掉，并截取[]中的数据
				plateIds = plateIds.substring(1, plateIds.lastIndexOf("]")).replaceAll("\"", "");
				// 将字符窜进行拆分为数组
				String[] pids = plateIds.split(",");
				int result=pd.delAll(pids);
				if(result>0) {
					return true;
				}else {
					return false;
				}
	}
	
	
}
