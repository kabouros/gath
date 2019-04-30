package com.kabouros.gath.web.http;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author JIANG
 */
public enum HttpResultStatus implements CharSequence {
	
	OK(200);
	
    private static final Map<Integer, HttpResultStatus> BY_CODE;

    static {
    	HttpResultStatus[] statuses = values();
        Map<Integer, HttpResultStatus> byCode = new LinkedHashMap<>();
        for (HttpResultStatus status : statuses) {
            byCode.put(status.code, status);
        }
        BY_CODE = Collections.unmodifiableMap(byCode);
    }
	
	private final int code;
	
    /**
     * @param code   The code
     */
	HttpResultStatus(int code) {
        this.code = code;
    }
	
    /**
     * @return The code
     */
    public int getCode() {
        return code;
    }

    /**
     * The status for the given code.
     *
     * @param code The code
     * @return The value
     */
    public static HttpResultStatus valueOf(int code) {
    	HttpResultStatus status = BY_CODE.get(code);
        if (status == null) {
            throw new IllegalArgumentException("Invalid Response status code: " + code);
        }
        return status;
    }

    @Override
    public int length() {
        return name().length();
    }

    @Override
    public char charAt(int index) {
        return name().charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return name().subSequence(start, end);
    }
    
    @Override
    public String toString() {
    	
    	return String.valueOf(this.code);
    }
    
    
}
