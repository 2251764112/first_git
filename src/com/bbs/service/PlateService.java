package com.bbs.service;

import java.text.ParseException;
import java.util.List;

import com.bbs.entity.Plate;

public interface PlateService {
	boolean savePlate(Plate plate);

	List<Plate> getPlateList() throws ParseException;
	
	Plate findEdit(int plateId);

	boolean delById(String plateId);

	boolean update(Plate plate);

	boolean delAll(String plateIds);


}
