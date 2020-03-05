package com.tuningboard.domain;

public enum DetailType {
	
	DATA_SKEW("DATA_SKEW"), 
	IO지연("IO지연"), 
	REORG("REORG"), 
	TMF("TMF"), 
	개선불능("개선불능"), 
	락대기("락대기"),
	NA("NA");

    private String value;

    DetailType(String value) {
        this.value = value;
    }

    public String getKey() {
        return name();
    }
    
    public String getValue() {
        return value;
    }

}
