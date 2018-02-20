package com.bricks.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bricks.bean.BricksBean;


@PropertySource("classpath:/com/bricks/resources/bricks.properties")
@Repository("bricksDao")
public class BricksDaoImpl implements BricksDao{
	    @Autowired
		private JdbcTemplate jdbcTemplate;

		@Override
		public String noOfBricksOrder(BricksBean bricksBean) {
			String QUERY="INSERT INTO `bricks_tab` (`userName`,`noOfBricks`) VALUES(?,?)";
			String result=null;
			long referenceval=0;
			try{
	    		int val = jdbcTemplate.update(QUERY, new Object[]{bricksBean.getUserName().trim(),bricksBean.getNoOfBricks()});
	    		if(val >0){
	    			List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT LAST_INSERT_ID() AS referenceID");
	    			if(rows != null && rows.size()>0) {
	    				for(Map row : rows){
	    					referenceval=Long.parseLong(row.get("referenceID").toString());
	    				  }
	    			}
	    			result="Successfully Request Submitted, Your Order Reference is "+referenceval;
	    		}
	    	}catch(Exception e){
	    		result="Some thing went wrong";
	    		e.printStackTrace();
	    	}finally{
	    		//session.close();
	    	}
	    
			return result;
		}
	   

}
