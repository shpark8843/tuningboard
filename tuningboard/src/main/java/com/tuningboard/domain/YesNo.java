package com.tuningboard.domain;

public enum YesNo {
    Y("Y"), 
    N("N"),
    조건부("조건부");
    
    private String value;

    YesNo(String value) {
        this.value = value;
    }

    public String getKey() {
        return name();
    }
    
    public String getValue() {
        return value;
    }
}

