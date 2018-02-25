package com.rcb.utils;

import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CustomizedResponse {
	
	private Object response;
	private List<String> statusList;
	private boolean success;
	
	public Object getResponse() {return response;}
	
	public void setResponse(Object response) {this.response = response;}

	public List<String> getStatusList() {return statusList;}

	public void setStatusList(List<String> statusList) {this.statusList = statusList;}

	public boolean isSuccess() {return success;}

	public void setSuccess(boolean success) {this.success = success;}

	
}
