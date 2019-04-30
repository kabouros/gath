package com.kabouros.gath.web.http;

import com.kabouros.gath.web.http.simple.SimpleHttpResultFactory;

/**
 * A factory interface for creating {@link MutableHttpResult} instances.
 *
 * @author JIANG
 */
public interface HttpResultFactory {
	
    /**
     * The default {@link com.kabouros.gath.web.http.simple.SimpleHttpResultFactory} instance.
     */
	HttpResultFactory INSTANCE = new SimpleHttpResultFactory();

    /**
     * Return a response for the given status.
     *
     * @param status The status
     * @param reason An alternatively reason message
     * @param <T>    The response type
     * @return The response
     */
    <T> MutableHttpResult<T> status(HttpResultStatus status, String reason);

    /**
     * Return a response for the given status.
     *
     * @param status The status
     * @param body   The body
     * @param <T>    The body type
     * @return The response
     */
    <T> MutableHttpResult<T> body(HttpResultStatus status, T body);
    
    /**
     * Return a response for the given status.
     *
     * @param status The status
     * @param reason An alternatively reason message
     * @param body   The body
     * @param <T>    The body type
     * @return The response
     */
    <T> MutableHttpResult<T> build(HttpResultStatus status, String reason, T body);

    /**
     * @param <T> The response type
     * @return The ok response
     */
    default <T> MutableHttpResult<T> ok() {
        return ok(null);
    }
    
    /**
     * Creates an {@link com.kabouros.gath.web.http.HttpResultStatus#OK} response with a body.
     *
     * @param body The body
     * @param <T>  The body type
     * @return The ok response with the given body
     */
    default <T> MutableHttpResult<T> ok(T body){
    	return body(HttpResultStatus.OK,body);
    }

    /**
     * @param status The status
     * @param <T>    The response type
     * @return The restus response
     */
    default <T> MutableHttpResult<T> status(HttpResultStatus status) {
        return body(status, null);
    }
}
