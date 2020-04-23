package cn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.dao.RealDao;
import cn.pojo.Real;
import cn.service.Real_EstateService;

@Service("realService")
public class Real_EstateServiceImpl implements Real_EstateService {
    @Autowired 
    //创建一个dao层对象
    @Qualifier("realDao")
	private RealDao realDao;
	@Override
	public List<Real> getAll(int currPage, int pageSize, String cardid, String name) {
		return realDao.getAll(currPage, pageSize, cardid, name);
	}
	@Override
	public int getCount(String cardid, String name) {
		return realDao.getCount(cardid, name);
	}

}
