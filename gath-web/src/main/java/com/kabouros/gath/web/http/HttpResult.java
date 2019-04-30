package com.kabouros.gath.web.http;

/**
 * @param <T> The Result body type
 * @author JIANG
 */
public interface HttpResult<T> {
	
	String DEFAULT_OK_MSG = "success";
	
	/**
	 * @return The body
	 */
	T getBody();
	
    /**
     * @return The current status
     */
    HttpResultStatus getStatus();
    

    /**
     * @return The response status code
     */
    default int state() {
        return getStatus().getCode();
    }
    
	/**
	 * @return The msg
	 */
	String getMsg();
    
    /**
     * Return an {@link com.kabouros.gath.web.http.HttpResultStatus#OK} response with an empty body.
     *
     * @param <T> The response type
     * @return The ok response
     */
    static <T> MutableHttpResult<T> ok() {
        return HttpResultFactory.INSTANCE.ok();
    }
    /**
     * Return an {@link com.kabouros.gath.web.http.HttpResultStatus#OK} response with a body.
     *
     * @param body The response body
     * @param <T>  The body type
     * @return The ok response
     */
    static <T> MutableHttpResult<T> ok(T body) {
        return HttpResultFactory.INSTANCE.ok(body);
    }
    
    /**
     * Return a response for the given status.
     *
     * @param status The status
     * @param <T>    The response type
     * @return The response
     */
    static <T> MutableHttpResult<T> status(HttpResultStatus status) {
        return HttpResultFactory.INSTANCE.status(status);
    }

    /**
     * Return a response for the given status.
     *
     * @param status The status
     * @param reason An alternatively reason message
     * @param <T>    The response type
     * @return The response
     */
    static <T> MutableHttpResult<T> status(HttpResultStatus status, String reason) {
        return HttpResultFactory.INSTANCE.status(status, reason);
    }
    
    /**
     * Return a response for the given status.
     *
     * @param status The status
     * @param reason An alternatively reason message
     * @param body The response body
     * @param <T>    The response type
     * @return The response
     */
    static <T> HttpResult<T> build(HttpResultStatus status, String reason, T body) {
        return HttpResultFactory.INSTANCE.build(status, reason, body);
    }

}
