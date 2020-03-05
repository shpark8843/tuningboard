package com.tuningboard.domain;

public enum DefType {
	
	APP("APP"), 
	SQL("SQL"), 
	APPSQL("SQL"), 
	TMF("TMF"), 
	SSO("SSO"), 
	IF("IF"),
	NA("NA");
	
    private String value;

	DefType(String value) {
        this.value = value;
    }

    public String getKey() {
        return name();
    }
    
    public String getValue() {
        return value;
    }
}
