package com.tuningboard.domain;

public enum Type {
	
	KSIOP("KSIOP"), 
	WS("WS"); 
    
    private String value;

	Type(String value) {
        this.value = value;
    }

    public String getKey() {
        return name();
    }
    
    public String getValue() {
        return value;
    }
}