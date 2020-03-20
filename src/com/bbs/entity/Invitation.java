package com.bbs.entity;

import java.util.Date;

public class Invitation {
	private String invitationId;
	private String invitationMessage;
	private String userId;
	private String plateTitle;
	private int categoryId;
	private int isPass;
	private int isEnable;
	private int isCream;
	private Date invitationCreate;
	private Date invitationModify;
	public String getInvitationId() {
		return invitationId;
	}
	public void setInvitationId(String invitationId) {
		this.invitationId = invitationId;
	}
	public String getInvitationMessage() {
		return invitationMessage;
	}
	public void setInvitationMessage(String invitationMessage) {
		this.invitationMessage = invitationMessage;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPlateTitle() {
		return plateTitle;
	}
	public void setPlateTitle(String plateTitle) {
		this.plateTitle = plateTitle;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getIsPass() {
		return isPass;
	}
	public void setIsPass(int isPass) {
		this.isPass = isPass;
	}
	public int getIsEnable() {
		return isEnable;
	}
	public void setIsEnable(int isEnable) {
		this.isEnable = isEnable;
	}
	public int getIsCream() {
		return isCream;
	}
	public void setIsCream(int isCream) {
		this.isCream = isCream;
	}
	public Date getInvitationCreate() {
		return invitationCreate;
	}
	public void setInvitationCreate(Date invitationCreate) {
		this.invitationCreate = invitationCreate;
	}
	public Date getInvitationModify() {
		return invitationModify;
	}
	public void setInvitationModify(Date invitationModify) {
		this.invitationModify = invitationModify;
	}
	
	public Invitation(String invitationId, String invitationMessage, String userId, String plateTitle, int categoryId,
			int isPass, int isEnable, int isCream, Date invitationCreate, Date invitationModify) {
		super();
		this.invitationId = invitationId;
		this.invitationMessage = invitationMessage;
		this.userId = userId;
		this.plateTitle = plateTitle;
		this.categoryId = categoryId;
		this.isPass = isPass;
		this.isEnable = isEnable;
		this.isCream = isCream;
		this.invitationCreate = invitationCreate;
		this.invitationModify = invitationModify;
	}
	public Invitation(String invitationId, String invitationMessage, String userId, String plateTitle, int categoryId) {
		super();
		this.invitationId = invitationId;
		this.invitationMessage = invitationMessage;
		this.userId = userId;
		this.plateTitle = plateTitle;
		this.categoryId = categoryId;
	}
	
	public Invitation() {
		super();
	}
	
	
	
	
}
