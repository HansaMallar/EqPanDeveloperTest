package com.pancredit.application;

import java.time.LocalDateTime;
import java.util.Date;

import org.json.simple.JSONObject;

public class Application {

	String id;
	long applicationId;
	String type;
	String summary;
	double amount;
	String postingDate;
	Boolean isCleared;
	String clearedDate;

	public Application(JSONObject json) {
		this.id = (String) json.get("Id");
		this.applicationId = (long) json.get("ApplicationId");
		this.type = (String) json.get("Type");
		this.summary = (String) json.get("Summary");
		this.amount = (double) json.get("Amount");
		this.isCleared = (Boolean) json.get("IsCleared");
		this.postingDate = (String)json.get("PostingDate");
		this.clearedDate = (String)json.get("ClearedDate");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public float getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(long applicationId) {
		this.applicationId = applicationId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(LocalDateTime postingDate) {
		this.postingDate = postingDate;
	}

	public Boolean getIsCleared() {
		return isCleared;
	}

	public void setIsCleared(Boolean isCleared) {
		this.isCleared = isCleared;
	}

	public LocalDateTime getClearedDate() {
		return clearedDate;
	}

	public void setClearedDate(LocalDateTime clearedDate) {
		this.clearedDate = clearedDate;
	}

	public String toString() {
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append(" id " + id);
		strBuffer.append(" applicationId " + applicationId);
		strBuffer.append(" type " + type);
		strBuffer.append(" summary " + summary);
		strBuffer.append(" postingDate " + postingDate);
		strBuffer.append(" isCleared" + isCleared);
		strBuffer.append(" clearedDate " + clearedDate);
		return strBuffer.toString();
		
	}
	@SuppressWarnings("unchecked")
	public JSONObject toJsonObject() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", id);
		jsonObject.put("applicationId", applicationId);
		jsonObject.put("summary", summary);
		jsonObject.put("type", type);
		jsonObject.put("postingDate", postingDate);
		jsonObject.put("isCleared", isCleared);
		jsonObject.put("clearedDate", clearedDate);
		return jsonObject;
		
		
	}
}
