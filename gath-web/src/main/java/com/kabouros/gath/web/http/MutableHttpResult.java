package com.kabouros.gath.web.http;

/**
 * @param <T> The body response type
 * @author JIANG
 */
public interface MutableHttpResult<T> extends HttpResult<T> {
	
    /**
     * Sets the body.
     *
     * @param body The body
     * @return This response object
     */
    MutableHttpResult<T> body(T body);

    /**
     * Sets the response status.
     *
     * @param status  The status
     * @return This response object
     */
    MutableHttpResult<T> status(HttpResultStatus status);
    
    /**
     * Sets the response reason.
     *
     * @param reason The message
     * @return This response object
     */
    MutableHttpResult<T> reason(String reason);
    
}
