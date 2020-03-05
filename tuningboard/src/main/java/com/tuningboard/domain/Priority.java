package com.tuningboard.domain;

public enum Priority {

	MCP("MCP"), 
	CP("CP"), 
	기타("기타");
	
    private String value;

    Priority(String value) {
        this.value = value;
    }

    public String getKey() {
        return name();
    }
    
    public String getValue() {
        return value;
    }	
}
