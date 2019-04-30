package com.kabouros.gath.web.http.simple;

import com.kabouros.gath.web.http.HttpResultStatus;
import com.kabouros.gath.web.http.MutableHttpResult;

/**
 * Simple {@link MutableHttpResult} implementation.
 *
 * @param <T> the type of the body
 *
 * @author JIANG
 * @since 1.0
 */
class SimpleHttpResult<T> implements MutableHttpResult<T>{
	
    private HttpResultStatus state = HttpResultStatus.OK;
    private String msg = DEFAULT_OK_MSG;
    private T body;
    
    @Override
    public MutableHttpResult<T> body(T body) {
        this.body = body;
        return this;
    }

    @Override
    public MutableHttpResult<T> status(HttpResultStatus status) {
        this.state = status;
        return this;
    }
    
    @Override
    public MutableHttpResult<T> reason(String reason) {
        this.msg = reason;
        return this;
    }
    
    @Override
    public T getBody() {
        return this.body;
    }

    @Override
    public HttpResultStatus getStatus() {
        return this.state;
    }
    
    @Override
    public String getMsg(){
    	return this.msg;
    }
}
