package com.tuningboard.domain;

public enum Status {

	NEW("NEW"),
    OPEN("OPEN"),
    UNDER_GUIDE("UNDER_GUIDE"),
    IN_PROGRESS("IN_PROGRESS"),
    FIXED("FIXED"),
    CLOSED("CLOSED"),
    CLOSED1("CLOSED1"),
    REOPEN("REOPEN");

    private String value;

    Status(String value) {
        this.value = value;
    }

    public String getKey() {
        return name();
    }
    
    public String getValue() {
        return value;
    }
}