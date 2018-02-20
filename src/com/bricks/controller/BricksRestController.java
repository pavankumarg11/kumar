package com.bricks.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bricks.bean.BricksBean;
import com.bricks.services.BricksService;

@RestController
public class BricksRestController {
	
	@Autowired
	BricksService bricksService;
	
	 @PostMapping(path = "/bricksOrder", produces = MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody String  noOfBricksOrder(@RequestBody BricksBean bricksBean) {
		System.out.println(bricksBean.getNoOfBricks());
		 String result = null;
		 boolean number=false;
		 try{
			 boolean name=validateName(bricksBean.getUserName());
			 if(!name){
				 result="Please Enter Valid Name";
				 return result;
			 }
			 if(bricksBean.getNoOfBricks() <= 0){
				 result="Please Enter Valid Quantity";
				 return result;
			 }
				 result=bricksService.noOfBricksOrder(bricksBean);
				 System.out.println("result>>> "+result);
		 }catch(Exception e){
			 result="Please Enter Valid Quantity";
			 e.printStackTrace();
		 }
		 return result;
		 
	 }
	 public static boolean validateName(String txt) {

		    String regx = "^[\\p{L} .'-]+$";
		    Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
		    Matcher matcher = pattern.matcher(txt);
		    return matcher.find();

		}

}
