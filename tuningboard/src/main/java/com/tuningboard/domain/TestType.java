package com.tuningboard.domain;

public enum TestType {

	UT("UT"), 
	SIT("SIT"), 
	UAT("UAT"), 
	REHEARSAL("REHEARSAL"), 
	PT("PT"),
	OPERATION("OPERATION");

    private String value;

    TestType(String value) {
        this.value = value;
    }

    public String getKey() {
        return name();
    }
    
    public String getValue() {
        return value;
    }
}
