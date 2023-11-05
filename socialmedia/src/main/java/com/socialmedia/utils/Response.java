package com.socialmedia.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public class Response {
    private int status;
    private String message;
    private List<Object> data;
    private List<String> violations;
    private String timestamp;

    public Response() {
    	this.status=HttpStatus.BAD_REQUEST.value();
    	this.message="Something wents wrong";
    	this.timestamp = formatDate(new Date());
        this.violations = new ArrayList<>();
        this.data = new ArrayList<>();

    }
    private String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public List<Object> getData() {
		return data;
	}

	public List<String> getViolations() {
		return violations;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setData(List<Object> data) {
		this.data = data;
	}

	public void setViolations(List<String> violations) {
		this.violations = violations;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
    
}
