package com.bricks.bean;

public class BricksBean {
	
	private int bricksId;
	private String UserName;
	private Long noOfBricks;
	public int getBricksId() {
		return bricksId;
	}
	public void setBricksId(int bricksId) {
		this.bricksId = bricksId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public Long getNoOfBricks() {
		return noOfBricks;
	}
	public void setNoOfBricks(Long noOfBricks) {
		this.noOfBricks = noOfBricks;
	}
	@Override
	public String toString() {
		return "BricksBean [bricksId=" + bricksId + ", UserName=" + UserName + ", noOfBricks=" + noOfBricks + "]";
	}

}
