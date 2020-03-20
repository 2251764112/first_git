package com.bbs.dao.user;

import java.text.ParseException;
import java.util.List;

import com.bbs.entity.Plate;

public interface PlateDao {


	int savePlate(Plate plate);

	List<Plate> getPlateList() throws ParseException;
	
	Plate findEdit(int plateId);

	int delById(String plateId);

	int update(Plate plate);

	int delAll(String[] pids);

	
	
}
