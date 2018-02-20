package com.bricks.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bricks.bean.BricksBean;
import com.bricks.dao.BricksDao;

@Service ("bricksService")
public class BricksServiceImpl implements BricksService{
 
	@Autowired
	BricksDao bricksDao;

	@Override
	public String noOfBricksOrder(BricksBean bricksBean) {
		// TODO Auto-generated method stub
		return bricksDao.noOfBricksOrder(bricksBean);
	}
	

}
